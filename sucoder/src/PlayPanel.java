/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel that contains new game and load game buttons
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required libraries for this class
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PlayPanel extends JPanel{

	JLabel mainBackground;
	static JButton backButton, btnNewGame, btnLoadGame;
	static JToggleButton toggleButtonMusic;

	public PlayPanel(){

		setBounds(0, 0, 1274, 691);
		setLayout(null);
		
		// New Game Button
		btnNewGame = new JButton("<html><center>New<br>Game</center></html>");
		btnNewGame.setFocusPainted(false);
		btnNewGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewGame.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewGame.setFont(new Font("Chalkduster", Font.BOLD, 43));
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setBorder(null);
		btnNewGame.setBounds(835, 133, 258, 200);
		btnNewGame.addActionListener(new GameSelectListener());
		btnNewGame.setToolTipText("Start a New Game");
		add(btnNewGame);	
		
		// Load Game Button
		btnLoadGame = new JButton("<html><center>Load<br>Game</center></html>");
		btnLoadGame.setFocusPainted(false);
		btnLoadGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLoadGame.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLoadGame.setForeground(Color.WHITE);
		btnLoadGame.setFont(new Font("Chalkduster", Font.BOLD, 43));
		btnLoadGame.setContentAreaFilled(false);
		btnLoadGame.setBorder(null);
		btnLoadGame.setBounds(835, 344, 258, 200);
		btnLoadGame.addActionListener(new GamePlayListener());
		btnLoadGame.setToolTipText("Load a Saved Game");
		add(btnLoadGame);	
		
		// Music On/Off Quick Button
		toggleButtonMusic = new JToggleButton();
		toggleButtonMusic.setFocusPainted(false);
		toggleButtonMusic.setSelected(true);
		toggleButtonMusic.setBorder(null);
		toggleButtonMusic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toggleButtonMusic.setContentAreaFilled(false);
		toggleButtonMusic.setBounds(25, 11, 55, 55);
		toggleButtonMusic.addItemListener( new MusicIconListener());
		toggleButtonMusic.setToolTipText("Click to stop music");
		add(toggleButtonMusic);
		
		// Back Button returns to Start Panel
		backButton = new JButton();
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1200, 11, 58, 58);
		backButton.addActionListener(new MainMenuListener());
		backButton.setToolTipText("Click to go back Start Menu");
		add(backButton);
		
		// Background 
		mainBackground = new JLabel("");
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		// Buffering images with Exceptions
		try {
			btnNewGame.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbigbutton2.png")));
			btnNewGame.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/bigbutton2.png")));
			btnLoadGame.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbigbutton2.png")));
			btnLoadGame.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/bigbutton2.png")));
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	}
}
