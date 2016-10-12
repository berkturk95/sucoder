/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Key press listener of the frame
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required libraries for this class
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressListener implements KeyListener{
		
		//Even any key pressed, welcome panel becomes unvisible and main menu panel becomes visible
		@Override
		public void keyPressed(KeyEvent e){
			try {
			    Thread.sleep(400);
			}catch (InterruptedException e2){
			}
			MainFrame.welcomePanel.setVisible(false);
			MainFrame.mainMenuPanel.setVisible(true);
			MainFrame.current.loop();
		}

		@Override
		public void keyReleased(KeyEvent e){
			//Necessary method
		}

		@Override
		public void keyTyped(KeyEvent e){
			//Necessary method
		}
	}

