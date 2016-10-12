/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Contains music toggle button listener
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required libraries for this class
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MusicIconListener implements ItemListener {
	
	@Override
	public void itemStateChanged(ItemEvent arg0){
		//Toggle music button action performed method
		if(arg0.getStateChange()==ItemEvent.SELECTED){
			//Sets selected the toggle button in every panel
			MainMenuPanel.toggleButtonMusic.setSelected(true);
			StartPanel.toggleButtonMusic.setSelected(true);
			HowToPlayPanel.toggleButtonMusic.setSelected(true);
			HighScoresPanel.toggleButtonMusic.setSelected(true);
			OptionsPanel.toggleButtonMusic.setSelected(true);
			CreditsPanel.toggleButtonMusic.setSelected(true);
			ThemesPanel.toggleButtonMusic.setSelected(true);
			MusicsPanel.toggleButtonMusic.setSelected(true);
			PlayPanel.toggleButtonMusic.setSelected(true);
			PlaySudokuPanel.toggleButtonMusic.setSelected(true);
			SudokuSolverPanel.toggleButtonMusic.setSelected(true);
			
			//Changes tool tip texts of these buttons
			MainMenuPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			StartPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			HowToPlayPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			HighScoresPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			OptionsPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			CreditsPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			ThemesPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			MusicsPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			PlayPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			PlaySudokuPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			SudokuSolverPanel.toggleButtonMusic.setToolTipText("Click to stop music");
			
			//Loops music
			MainFrame.current.loop();
		}
		
		//If user clicks music icon on the left upper screen, sets selected the toggle button in every panel
		else if(arg0.getStateChange()==ItemEvent.DESELECTED){
			//Sets deselected the toggle button in every panel
			MainMenuPanel.toggleButtonMusic.setSelected(false);
			StartPanel.toggleButtonMusic.setSelected(false);
			HowToPlayPanel.toggleButtonMusic.setSelected(false);
			HighScoresPanel.toggleButtonMusic.setSelected(false);
			OptionsPanel.toggleButtonMusic.setSelected(false);
			CreditsPanel.toggleButtonMusic.setSelected(false);
			ThemesPanel.toggleButtonMusic.setSelected(false);
			MusicsPanel.toggleButtonMusic.setSelected(false);
			PlayPanel.toggleButtonMusic.setSelected(false);
			PlaySudokuPanel.toggleButtonMusic.setSelected(false);
			SudokuSolverPanel.toggleButtonMusic.setSelected(false);
			
			//Changes tool tip texts of these buttons
			MainMenuPanel.toggleButtonMusic.setToolTipText("Click to play music");
			StartPanel.toggleButtonMusic.setToolTipText("Click to play music");
			HowToPlayPanel.toggleButtonMusic.setToolTipText("Click to play music");
			HighScoresPanel.toggleButtonMusic.setToolTipText("Click to play music");
			OptionsPanel.toggleButtonMusic.setToolTipText("Click to play music");
			CreditsPanel.toggleButtonMusic.setToolTipText("Click to play music");
			ThemesPanel.toggleButtonMusic.setToolTipText("Click to play music");
			MusicsPanel.toggleButtonMusic.setToolTipText("Click to play music");
			PlayPanel.toggleButtonMusic.setToolTipText("Click to play music");
			PlaySudokuPanel.toggleButtonMusic.setToolTipText("Click to play music");
			SudokuSolverPanel.toggleButtonMusic.setToolTipText("Click to play music");
			
			//Stops music
			MainFrame.current.stop();
		}
	}
}
