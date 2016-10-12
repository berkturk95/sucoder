/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Class contains Main Menu button listeners
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

public class MainMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Start button action performed method
			if(e.getSource()==MainMenuPanel.btnStart){
				MainFrame.mainMenuPanel.setVisible(false);
				MainFrame.startPanel.setVisible(true);
			}
			//How to Play button action performed method
			else if(e.getSource()==MainMenuPanel.btnHowToPlay){
				MainFrame.mainMenuPanel.setVisible(false);
				MainFrame.howToPlayPanel.setVisible(true);
			}
			//High Scores button action performed method
			else if(e.getSource()==MainMenuPanel.btnHighScores){
				MainFrame.mainMenuPanel.setVisible(false);
				MainFrame.highScoresPanel.setVisible(true);
			}
			//Options button action performed method
			else if(e.getSource()==MainMenuPanel.btnOptions){
				MainFrame.mainMenuPanel.setVisible(false);
				MainFrame.optionsPanel.setVisible(true);
			}
			//Credits button action performed method
			else if(e.getSource()==MainMenuPanel.btnCredits){
				MainFrame.mainMenuPanel.setVisible(false);
				MainFrame.creditsPanel.setVisible(true);
			}
			//Themes button action performed method
			else if(e.getSource()==OptionsPanel.btnThemes){
				MainFrame.optionsPanel.setVisible(false);
				MainFrame.themesPanel.setVisible(true);
			}
			//Musics button action performed method
			else if(e.getSource()==OptionsPanel.btnMusics){
				MainFrame.optionsPanel.setVisible(false);
				MainFrame.musicsPanel.setVisible(true);
			}
			//Play Sudoku Button action performed method
			else if(e.getSource()==StartPanel.playSudokuButton){
				MainFrame.startPanel.setVisible(false);
				MainFrame.playPanel.setVisible(true);
			}
			//Back buttons that have same actions (Goes Main Menu Panel)
			else if(e.getSource()== StartPanel.backButton || e.getSource()==HowToPlayPanel.backButton || e.getSource()== HighScoresPanel.backButton || e.getSource()== OptionsPanel.backButton || e.getSource()== CreditsPanel.backButton){
				MainFrame.mainMenuPanel.setVisible(true);
				MainFrame.startPanel.setVisible(false);
				MainFrame.howToPlayPanel.setVisible(false);
				MainFrame.highScoresPanel.setVisible(false);
				MainFrame.optionsPanel.setVisible(false);
				MainFrame.creditsPanel.setVisible(false);
			}
			//Back buttons action performed method (Goes Options Panel)
			else if(e.getSource()== ThemesPanel.backButton || e.getSource()==MusicsPanel.backButton){
				MainFrame.optionsPanel.setVisible(true);
				MainFrame.themesPanel.setVisible(false);
				MainFrame.musicsPanel.setVisible(false);
			}
			//Back buttons action performed method (Goes Start Panel)
			else if(e.getSource()== PlayPanel.backButton || e.getSource()==SudokuSolverPanel.backButton){
				MainFrame.startPanel.setVisible(true);
				MainFrame.playPanel.setVisible(false);
				MainFrame.sudokuSolverPanel.setVisible(false);
			}
			//Clear Button action performed method
			else if(e.getSource()==HighScoresPanel.btnClear){
				HighScoresPanel.highScoreManager.resetHighScore();
				HighScoresPanel.textPaneNames.setText(HighScoresPanel.highScoreManager.getHighScore_Names());
		        HighScoresPanel.textPaneScores.setText(HighScoresPanel.highScoreManager.getHighScore_Scores());
			}
		}
	}

