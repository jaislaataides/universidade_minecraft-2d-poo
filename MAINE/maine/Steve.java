package maine;

import java.util.Random;

public final class Steve{
    //------------------------ atributos ------------------------------------
    //constantes
    private final int bloco_vazio = 4;
    
    //variáveis
    private int posicao_cabeca;
    private int posicao_pe;
    
    private static int selected_block = 1;
    
    private final String head_adress[] = {".//src//imagens//bloco_cabeca_steve_oeste.png", ".//src//imagens//bloco_cabeca_steve_leste.png"};
    private final String feet_adress[] = {".//src//imagens//bloco_pe_steve_oeste.png", ".//src//imagens//bloco_pe_steve_leste.png"};
    private String steve_head;
    private String steve_foot;
    
    public Random rand = new Random();
    
    //objeto estático
    public static Steve steve = null;
    
    //------------------------ métodos --------------------------------------
    
    //SINGLETON
    public static Steve getInstancia(int inicio_blocos, int size, int width, MyPanel[] panels) {
        if(steve == null) {
            steve = new Steve(inicio_blocos, size, width, panels);
        }
        return steve;
    }
    
    //------- SPAWN -------
    private Steve(int inicio_blocos, int size, int width, MyPanel[] panels) {
        inicio_blocos -= width;
        
        //nasce na linha acima de onde os blocos spawnam
        posicao_pe = rand.nextInt(inicio_blocos, inicio_blocos+width);
        
        //nasce um bloco abaixo se o bloco da posição seguinte for vazio(ceu)
        for (int i = posicao_pe; i < size; i++){
            if (panels[posicao_pe + width].getTipo_de_bloco() == bloco_vazio){
                posicao_pe += width;
            } 
        }
        
        posicao_cabeca = posicao_pe - width;
        drawSteve(panels, 0);
    }
  
    // --- set img block ---
    public void setFacing(int direction) {
        if(direction == 0){//virado para leste
            steve_head = head_adress[0];
            steve_foot = feet_adress[0];
        }else{//virado para oeste
            steve_head = head_adress[1];
            steve_foot = feet_adress[1];
        }
    }

    public void setSelected_block(int selected_block) {
        Steve.selected_block = selected_block;
    }
    
    // --- getters ---
    public static int getSelected_block() {
        return selected_block;
    }
    
    public int getPosicao_cabeca() {
        return posicao_cabeca;
    }

    public int getPosicao_pe() {
        return posicao_pe;
    }

    public String getStevehead() {
        return steve_head;
    }

    public String getStevefoot() {
        return steve_foot;
    }
    
    //--- drawers ---
    public void drawSteve(MyPanel[] panels, int direction) {
        setFacing(direction);
        panels[posicao_cabeca].setImage(steve_head);
        panels[posicao_pe].setImage(steve_foot);
    }
    
    public void drawVoid(MyPanel[] panels) {
        panels[posicao_cabeca].setImage(bloco_vazio);
        panels[posicao_pe].setImage(bloco_vazio);
    }
    
    //------ MOVEMENT -------
    public void moveRight(MyPanel[] panels, int size, int width) {
        if(panels[posicao_pe + 1].getTipo_de_bloco() == bloco_vazio && panels[posicao_cabeca + 1].getTipo_de_bloco() == bloco_vazio){
            drawVoid(panels);
            
            posicao_cabeca++;
            posicao_pe++;
            
            for(int i = posicao_pe; i < size; i++) {
                if(panels[posicao_pe + width].getTipo_de_bloco() == bloco_vazio && (posicao_pe + width) < size){
                    panels[posicao_cabeca].setImage(bloco_vazio);
                    
                    posicao_cabeca = posicao_pe;
                    posicao_pe += width;
                    
                    drawSteve(panels, 1);
                }
            }

            drawSteve(panels, 1);
            
        }else{
            jumpRight(panels, width);  
        }
    }
    
    public void moveLeft(MyPanel[] panels, int size, int width) {
        if(panels[posicao_pe-1].getTipo_de_bloco() == bloco_vazio && panels[posicao_cabeca - 1].getTipo_de_bloco() == bloco_vazio) {
            drawVoid(panels);
            
            posicao_cabeca--;
            posicao_pe--;
            
            for(int i = posicao_pe; i < size; i++) {
                if(panels[posicao_pe + width].getTipo_de_bloco() == bloco_vazio && (posicao_pe + width) < size){
                    panels[posicao_cabeca].setImage(bloco_vazio);
                    
                    posicao_cabeca = posicao_pe;
                    posicao_pe += width;
                    
                    drawSteve(panels, 0);
                }
            }
            
            drawSteve(panels, 0);
        }else{
            jumpLeft(panels, width);
        }
    }
    
    public void jumpRight(MyPanel[] panels, int width) {
        if(panels[posicao_cabeca+1].getTipo_de_bloco() == bloco_vazio && panels[posicao_cabeca-(width-1)].getTipo_de_bloco() == bloco_vazio){
            
            drawVoid(panels);
            
            posicao_cabeca++;  
            posicao_pe = posicao_cabeca;
            posicao_cabeca -= width;

            drawSteve(panels, 1);
        }
               
    }
    
    public void jumpLeft(MyPanel[] panels, int width) {
        if(panels[posicao_cabeca-1].getTipo_de_bloco() == bloco_vazio && panels[posicao_cabeca-(width+1)].getTipo_de_bloco() == bloco_vazio){
            drawVoid(panels);
            
            posicao_cabeca--;
            posicao_pe = posicao_cabeca;
            posicao_cabeca -= width;  
            
            drawSteve(panels, 0);
        }
    } 
}