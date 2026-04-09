package maine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener {

    //------------------------------ atributos -------------------------------
    public static int bloco_vazio = 4;
    private int tipo_de_bloco;

    private ImageIcon icon;
    private final String adress[] = {" ", ".//src//imagens//bloco_pedra.png",".//src//imagens//bloco_terra.png",
        ".//src//imagens//bloco_terra_com_grama.png", ".//src//imagens//bloco_ceu.png","//src//imagens//picwish.png",
        ".//src//imagens//bloco_pedra.png",".//src//imagens//bloco_terra.png", ".//src//imagens//bloco_terra_com_grama.png"};
    
    private final String deterioracao1[] = {" ", ".//src//imagens//bloco_pedra_det1.png",".//src//imagens//bloco_terra_det1.png", 
        ".//src//imagens//bloco_terra_com_grama_det1.png"};
    
    private final String deterioracao2[] = {" ", ".//src//imagens//bloco_pedra_det2.png", ".//src//imagens//bloco_terra_det2.png",
        ".//src//imagens//bloco_terra_com_grama_det2.png"};
    
    private int nivel_deterioracao = 0;

    //------------------------------- métodos --------------------------------
    //builders
    public MyPanel() {
        tipo_de_bloco = bloco_vazio;
        icon = new ImageIcon(adress[tipo_de_bloco]);
        this.addMouseListener(this);
    }

    public MyPanel(int tipo_de_bloco) {
        this.tipo_de_bloco = tipo_de_bloco;
        icon = new ImageIcon(adress[tipo_de_bloco]);
    }

    public MyPanel(String adress) {
        icon = new ImageIcon(adress);
    }
    
    //getters
    public int getTipo_de_bloco() {
        return tipo_de_bloco;
    }

    public ImageIcon getIcon() {
        return icon;
    }
    
    //setters
    public void setRandomBlock(int position, int width, int size, MyPanel[] panels) {
        Random rand = new Random();
        if (position < (size + width))
            setImage(rand.nextInt(1, 5));
        else if (panels[position - width].getTipo_de_bloco() == bloco_vazio)
            setImage(rand.nextInt(1, 5));
        else
            setImage(rand.nextInt(1, 3));
    }

    public void setImage(String adress) {
        icon = new ImageIcon(adress);
        repaint();
    }

    public void setImage(int tipo_de_bloco) {
        this.tipo_de_bloco = tipo_de_bloco;
        
        if(tipo_de_bloco <= 8){
            setImage(adress[tipo_de_bloco]);
        }
    }
    
    public void setHotBarSelected() {
        if(Steve.getSelected_block() + 5 == tipo_de_bloco) {
            this.setBackground(Color.red);
        } else if(tipo_de_bloco > 4) {
            this.setBackground(Color.GRAY);
        }
    }

    //DESENHO
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        if(tipo_de_bloco < 5) {
            g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        } else {
            g.drawImage(icon.getImage(), 5, 5, (this.getWidth() - 10), (this.getHeight() - 10), null);
        }
    }

    //AÇÕES
    @Override
    public void mouseClicked(MouseEvent e) {
        if (getTipo_de_bloco() == bloco_vazio) {
            if (Steve.getSelected_block() != 0) {
                setImage(Steve.getSelected_block());
                repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Steve.getSelected_block() == 0 && Steve.getSelected_block() < 4) {
            switch (nivel_deterioracao) {
                case 0 -> {
                    nivel_deterioracao++;
                    setImage(deterioracao1[this.getTipo_de_bloco()]);
                }
                case 1 -> {
                    nivel_deterioracao++;
                    setImage(deterioracao2[this.getTipo_de_bloco()]);
                }
                case 2 -> {
                    nivel_deterioracao = 0;
                    setImage(bloco_vazio);
                }     
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}