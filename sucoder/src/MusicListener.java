/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Contains music listener
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
import javax.swing.JApplet;

public class MusicListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//Music 1 button action performed method
		if(e.getSource()==MusicsPanel.buttonMusic1 || e.getSource()==PlaySudokuPanel.buttonMusic1 || e.getSource()==SudokuSolverPanel.buttonMusic1){
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
			
			MainFrame.current.stop(); 										//Stops
			MainFrame.current = JApplet.newAudioClip(MainFrame.music1);		//Changes Music
			MainFrame.current.loop();										//Starts
		}
		
		//Music 2 button action performed method
		if(e.getSource()==MusicsPanel.buttonMusic2 || e.getSource()==PlaySudokuPanel.buttonMusic2 || e.getSource()==SudokuSolverPanel.buttonMusic2){
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
			
			MainFrame.current.stop();										//Stops
			MainFrame.current = JApplet.newAudioClip(MainFrame.music2);		//Changes Music
			MainFrame.current.loop();										//Starts
		}
		
		//Music 3 button action performed method
		if(e.getSource()==MusicsPanel.buttonMusic3 || e.getSource()==PlaySudokuPanel.buttonMusic3 || e.getSource()==SudokuSolverPanel.buttonMusic3){
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
			
			MainFrame.current.stop();										//Stops			
			MainFrame.current = JApplet.newAudioClip(MainFrame.music3);		//Changes Music
			MainFrame.current.loop();										//Starts
		}
	}
}


