/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Listener for choosing solve or game mode
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required libraries for this class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSelectListener implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
			//New Game Button Action Performed Method
			if(e.getSource()==PlayPanel.btnNewGame){
				MainFrame.playPanel.setVisible(false);
				MainFrame.playSudokuPanel.setVisible(true);
			}
			//Sudoku Solver Button Action Performed Method
			else if(e.getSource()==StartPanel.sudokuSolverButton){
				MainFrame.startPanel.setVisible(false);
				MainFrame.sudokuSolverPanel.setVisible(true);
			}
			//Back Button Action Performed Method
			else if(e.getSource()== PlaySudokuPanel.backButton){
				MainFrame.playPanel.setVisible(true);
				MainFrame.playSudokuPanel.setVisible(false);
			}
		}
}

