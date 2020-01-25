
package program_4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;



/**
 *
 * @author Alexis
 */

public class TicTacToeGame{
    static TicTacToeUI juego = new TicTacToeUI();
    //static ImageIcon icon = new ImageIcon();
    static String icon = "";
    static int count = 0;
    static boolean victory = false;
    static int nuevoJuego = 100;
        static int[][] convinacion = new int[][] {
	{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, 
	{0, 4, 8}, {2, 4, 6}             
    };
    
    
    
    
    public static void reset(){
        for(int j=0; j<3; j++){
        for(int i=0; i<3; i++){
            juego.buttons[j].setText("");
            convinacion[i][j] = 0;
        }}
    }
        
    
      public char move(ActionEvent e){

        count++;  
            if(count % 2 == 0){
                //icon = new ImageIcon("X.PNG");
                icon = "X";
            }else{
                //icon = new ImageIcon("O.PNG");
                icon = "O";
            }
            JButton selecionado = (JButton)e.getSource(); 
            selecionado.setText(icon);
            selecionado.setBackground(Color.YELLOW);
            selecionado.setEnabled(false);
            return ' ';
      }
      
      
     
    
    
    public static void checkWinner(){
        for(int i=0; i<=7; i++){
	if( juego.buttons[convinacion[i][0]].getText().equals(juego.buttons[convinacion[i][1]].getText()) &&
		juego.buttons[convinacion[i][1]].getText().equals(juego.buttons[convinacion[i][2]].getText()) &&
		juego.buttons[convinacion[i][0]].getText() != ""){
		victory = true;
	}
        }
        if(victory == true){
            nuevoJuego = JOptionPane.showConfirmDialog(null, "Player " + icon + " wins the game!  Do you want to play again?",
            "Congratulations!",JOptionPane.YES_NO_OPTION);
            if(nuevoJuego == JOptionPane.YES_OPTION){
                reset();
                count = 0;
                new TicTacToeUI();
            }else if(nuevoJuego == JOptionPane.NO_OPTION){
                System.exit(0);
            }
        }
    }
    
    
    
    public static boolean tie(){

    if(count == 9 && victory == false){
                nuevoJuego = JOptionPane.showConfirmDialog(null, "Tie Game!  Do you want to play again?",
            "Tie!",JOptionPane.YES_NO_OPTION);
            if(nuevoJuego == JOptionPane.YES_OPTION){
                reset();
                count = 0;
                new TicTacToeUI();
            }else if(nuevoJuego == JOptionPane.NO_OPTION){
                System.exit(0);
            }
    return true;
    }else
        return false;
    
}
    
}

