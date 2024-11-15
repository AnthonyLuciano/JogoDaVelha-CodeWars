import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * @author: Anthony Luciano
 */
public class jogodavelha extends JFrame implements ActionListener {
    private final JButton[][] botoes = new JButton[3][3];
    //info do jogador inicial adicionada
    //info de scoreboard adicionada
    private int vitoriasX = 0;
    private int vitoriasO = 0;
    private final JLabel labelVitorias;
    private char jogadorAtual = 'X';

    public jogodavelha(){
        //criar a janela java
        setTitle("Jogo Da Velha");
        setSize(300, 350); //tamanho aumentado para scoreboard
        
        labelVitorias = new JLabel("X: 0  O: 0", SwingConstants.CENTER);
        labelVitorias.setFont(new Font("Arial", Font.PLAIN, 20));
        add(labelVitorias, BorderLayout.NORTH);
        
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

@Override
public void actionPerformed(ActionEvent e) {
    JButton botaoClicado = (JButton) e.getSource();
    if (botaoClicado.getText().isEmpty()) {
        botaoClicado.setText(String.valueOf(jogadorAtual));
        if (verificarVitoria()) {
            if (jogadorAtual == 'X') {
                vitoriasX++;
            } else  {
                vitoriasO++;
            }
            atualizarLabelVitorias();
            JOptionPane.showMessageDialog(this, "Jogador " + jogadorAtual + " venceu!");
            reiniciarJogo();
        } else if (tabuleiroCheio()) {
                    JOptionPane.showMessageDialog(this, "Empate!");
                    reiniciarJogo();
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            }
        }
        
/*
 * os nomes sao os mesmos [:v]
 */
private boolean verificarVitoria() {
    // verifica linhas, colunas e diagonais
    for (int a = 0; a < 3; a++) {
        if (botoes[a][0].getText().equals(String.valueOf(jogadorAtual)) &&
            botoes[a][1].getText().equals(String.valueOf(jogadorAtual)) &&
            botoes[a][2].getText().equals(String.valueOf(jogadorAtual))) {
                return true;
        }
        if (botoes[0][a].getText().equals(String.valueOf(jogadorAtual)) &&
            botoes[1][a].getText().equals(String.valueOf(jogadorAtual)) &&
            botoes[2][a].getText().equals(String.valueOf(jogadorAtual))) {
                return true;
        }
    }
    //verifica as colunas
    return (botoes[0][0].getText().equals(String.valueOf(jogadorAtual)) &&
            botoes[1][1].getText().equals(String.valueOf(jogadorAtual)) &&
            botoes[2][2].getText().equals(String.valueOf(jogadorAtual))) ||
           (botoes[0][2].getText().equals(String.valueOf(jogadorAtual)) &&
            botoes[1][1].getText().equals(String.valueOf(jogadorAtual)) &&
            botoes[2][0].getText().equals(String.valueOf(jogadorAtual)));
}

private boolean tabuleiroCheio() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (botoes[i][j].getText().isEmpty()) {
                return false;
            }
        }
    }
   return true;
}    
private void reiniciarJogo(){
    for(int a = 0; a< 3; a++){
        for(int b = 0; b < 0; b++){

        }
    }
    jogadorAtual = 'X';
}
private void atualizarLabelVitorias() {
    labelVitorias.setText("X: " + vitoriasX + "  O: " + vitoriasO);
}
//main movida pro final do codigo, porque java é java.
    public static void main(String[] args) {
    new jogodavelha();
    }
}