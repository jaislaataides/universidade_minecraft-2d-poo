package maine;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Janela extends JFrame implements KeyListener {

    //--- constantes ----
    private final int height = 12;
    private final int width = 20;
    private final int size = height * width;
    private final int inicio_blocos = (size / 2) + width;

    //---- atributos ----
    protected MyPanel[] panels;
    private final Steve steve;
    private final Steve steve2;

    //----- métodos -----
    public Janela() {
        //inserção de blocos
        panels = new MyPanel[size];

        for (int i = 0; i < size; i++) {
            panels[i] = new MyPanel();
            this.add(panels[i]);
        }

        this.setLayout(new GridLayout(height, width));

        //criação aleatória de mundo
        for (int i = inicio_blocos; i < size; i++) {
            panels[i].setRandomBlock(i, width, inicio_blocos, panels);
        }

        //spawn steve
        steve = Steve.getInstancia(inicio_blocos, size, width, panels);
        steve2 = Steve.getInstancia(inicio_blocos, size, width, panels);
       
        setHotBar();

        //padronização da janela
        this.addKeyListener(this);
        this.setTitle("MINE");
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }

    //hotbar set
    private void setHotBar() {
        for(int i = 8; i < 12; i++){
            int j = i - 3;
            panels[i].setImage(j);
            panels[i].setHotBarSelected();
        }
    }
   
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            steve.moveLeft(panels, size, width);
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            steve.moveRight(panels, size, width);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
            steve.setSelected_block(0);
            setHotBar();
        }

        if (e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            steve.setSelected_block(1);
            setHotBar();
        }

        if (e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
            steve.setSelected_block(2);
            setHotBar();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            steve.setSelected_block(3);
            setHotBar();
        }
        
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}