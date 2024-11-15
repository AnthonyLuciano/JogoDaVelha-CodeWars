import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * @author: Anthony Luciano
 * commit date: 14/11/24
 */
public class jogodavelha extends JFrame implements ActionListener {
    private final JButton[][] botoes = new JButton[3][3];

    public jogodavelha(){
        //criar a janela java
        setTitle("Jogo Da Velha");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //gerar os botoes no estilo do jogo
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 3));
        for(int a = 0; a < 3; a++){
            for(int b = 0; b < 3; b++){
                //tentando fazer com que os botoes realmente aparecam
                //tentativa 1- falha
                botoes[a][b] = new JButton("");
            }
        }
    }
    public static void main(String[] args) {
        new jogodavelha();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}