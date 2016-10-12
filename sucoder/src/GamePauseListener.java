/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Contains play and pause toggle button listener
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

public class GamePauseListener implements ItemListener {
	
	private int temp = 0;	
	
	@Override
	public void itemStateChanged(ItemEvent arg0){
		//Toggle play pause button action performed method
		if(arg0.getStateChange()==ItemEvent.SELECTED){
			PlaySudokuPanel.sudokuPausedBackground.setVisible(true);
			PlaySudokuPanel.toggleButtonPlayPause.setToolTipText("Click to continue the game!");
			temp = GamePlayListener.countSec;
			PlaySudokuPanel.fakeCountTimeLabel.setText("Time: "+temp/600 + (temp/60)%10 +":"+(temp%60)/10+temp%10);
			PlaySudokuPanel.countTimeLabel.setVisible(false);
			PlaySudokuPanel.fakeCountTimeLabel.setVisible(true);
		}
		
		//If user clicks play pause icon, sets deselected the toggle button 
		else if(arg0.getStateChange()==ItemEvent.DESELECTED){
			
			PlaySudokuPanel.sudokuPausedBackground.setVisible(false);
			PlaySudokuPanel.toggleButtonPlayPause.setToolTipText("Click to pause the game!");
			GamePlayListener.countSec = temp;
			PlaySudokuPanel.countTimeLabel.setText("Time: "+GamePlayListener.countSec/600 + (GamePlayListener.countSec/60)%10 +":"+(GamePlayListener.countSec%60)/10+GamePlayListener.countSec%10);
			PlaySudokuPanel.countTimeLabel.setVisible(true);
			PlaySudokuPanel.fakeCountTimeLabel.setVisible(false);
		}
	}
}
