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
        //gerar os botoes no estilo do jogo
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 3));
        for(int a = 0; a < 3; a++){
            for(int b = 0; b < 3; b++){
                //comentarios vao ser menos a partir de agora
                botoes[a][b] = new JButton("");
                botoes[a][b].setFont(new Font("Arial", Font.PLAIN, 60));
                botoes[a][b].setFocusPainted(false);
                botoes[a][b].addActionListener(this);
                painelBotoes.add(botoes[a][b]);
            }
        }
        add(painelBotoes, BorderLayout.CENTER);
        //movido para ter mais logica e legibilidade
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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