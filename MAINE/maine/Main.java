package maine;
/*PADRÃO ESCOLHIDO: SINGLETON

Descrição: o padrão singleton utiliza de uma instância estática dentro da própria classe e de
um construtor privado para que haja apenas um objeto daquela classe.

Motivação: em razão do jogo que inspira esse código, o Minecraft, ter a modalidade single
player, o padrão Singleton foi utillizado para construir apenas um personagem: o Steve.

Além disso, como não há aplicação de física ou mobs nessa demo, não é possível matar o protagonista,
logo, não foi necessária a implementação de um método finalize().

O padrão foi aplicado na classe Steve. Na classe Janela pode-se encontrar duas instâncias dessa classe
para demonstrar a singularidade do padrão.
*/


public class Main {
    
    public static void main(String[] args) {
        new Janela();
    }
}
