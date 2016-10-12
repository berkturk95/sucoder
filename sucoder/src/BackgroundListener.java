/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Changes all background images on every panel
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
import javax.swing.ImageIcon;

public class BackgroundListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==ThemesPanel.buttonTheme1){		//When first theme button is clicked, Theme 1 becomes active
				try {
					MainFrame.mainMenuPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
					MainFrame.startPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
					MainFrame.howToPlayPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
					MainFrame.highScoresPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
					MainFrame.optionsPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
					MainFrame.creditsPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
					MainFrame.themesPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
					MainFrame.musicsPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
					MainFrame.playPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg"))); 
					MainFrame.playSudokuPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
					MainFrame.sudokuSolverPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
				}catch (NullPointerException e2) {
				}
			}
			else if(e.getSource()==ThemesPanel.buttonTheme2){	//When second theme button is clicked, Theme 2 becomes active
				try {
					MainFrame.mainMenuPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.startPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.howToPlayPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.highScoresPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.optionsPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.creditsPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.themesPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.musicsPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.playPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.playSudokuPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
					MainFrame.sudokuSolverPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground2.jpg")));
				}catch (NullPointerException e2) {
				}
			}
			else if(e.getSource()==ThemesPanel.buttonTheme3){	//When third theme button is clicked, Theme 3 becomes active
				try {
					MainFrame.mainMenuPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.startPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.howToPlayPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.highScoresPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.optionsPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.creditsPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.themesPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.musicsPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.playPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.playSudokuPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
					MainFrame.sudokuSolverPanel.mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground3.jpg")));
				}catch (NullPointerException e2) {
				}
			}
		}
}		

