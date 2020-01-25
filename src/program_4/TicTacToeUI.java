package program_4;
/**
 *
 * @author Alexis
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TicTacToeUI extends JFrame implements ActionListener{
    
    static JButton[] buttons = new JButton[9];
    TicTacToeGame juego = new TicTacToeGame();
    
    public TicTacToeUI(){
        super("Tic Tac Toe");
        this.setSize(600, 600);
        this.setLayout(new GridLayout(3,3));
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
            this.setVisible(true);
    }

        public void actionPerformed(ActionEvent e){
            juego.move(e);
            TicTacToeGame.checkWinner();
            TicTacToeGame.tie();
        }
        
    public static void main(String[] args) {
        new TicTacToeUI();
        
    }
    
}
