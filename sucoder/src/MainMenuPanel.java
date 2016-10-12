/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Main Menu class that contains menu buttons
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel{

	//Variables and components
	static JButton btnStart, btnHowToPlay, btnHighScores, btnOptions, btnCredits;
	static JToggleButton toggleButtonMusic;
	JLabel sucoderLogo;
	JLabel mainBackground;
	
	public MainMenuPanel(){
		// Panel Properties
		setBounds(0, 0, 1274, 691);																							
		setLayout(null);
		
		// Start Button
		btnStart = new JButton("Start");																					
		btnStart.setFocusPainted(false);
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStart.setFont(new Font("Chalkduster", Font.BOLD, 37));
		btnStart.setForeground(Color.WHITE);
		btnStart.setContentAreaFilled(false);
		btnStart.setBorder(null);
		btnStart.setBounds(820, 220, 225, 80);
		btnStart.addActionListener(new MainMenuListener());
		btnStart.setToolTipText("Start playing Sucoder!");
		add(btnStart);
		
		// How To Play Button
		btnHowToPlay = new JButton("How to Play");																			
		btnHowToPlay.setFocusPainted(false);
		btnHowToPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHowToPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHowToPlay.setFont(new Font("Chalkduster", Font.BOLD, 27));
		btnHowToPlay.setForeground(Color.WHITE);
		btnHowToPlay.setContentAreaFilled(false);
		btnHowToPlay.setBorder(null);
		btnHowToPlay.setBounds(820, 305, 225, 80);
		btnHowToPlay.addActionListener( new MainMenuListener());
		btnHowToPlay.setToolTipText("Learn how to play Sudoku!");
		add(btnHowToPlay);
		
		// High Scores Button
		btnHighScores = new JButton("High Scores");																			
		btnHighScores.setFocusPainted(false);
		btnHighScores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHighScores.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHighScores.setFont(new Font("Chalkduster", Font.BOLD, 28));
		btnHighScores.setForeground(Color.WHITE);
		btnHighScores.setContentAreaFilled(false);
		btnHighScores.setBorder(null);
		btnHighScores.setBounds(820, 390, 225, 80);
		btnHighScores.addActionListener( new MainMenuListener());
		btnHighScores.setToolTipText("See the High Scores!");
		add(btnHighScores);
		
		// Options Button
		btnOptions = new JButton("Options");																				
		btnOptions.setFocusPainted(false);
		btnOptions.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOptions.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOptions.setFont(new Font("Chalkduster", Font.BOLD, 32));
		btnOptions.setForeground(Color.WHITE);
		btnOptions.setContentAreaFilled(false);
		btnOptions.setBorder(null);
		btnOptions.setBounds(820, 475, 225, 80);
		btnOptions.addActionListener( new MainMenuListener());
		btnOptions.setToolTipText("Set the options of game!");
		add(btnOptions);
		
		// Credits Button
		btnCredits = new JButton("Credits");																				
		btnCredits.setFocusPainted(false);
		btnCredits.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCredits.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCredits.setFont(new Font("Chalkduster", Font.BOLD, 32));
		btnCredits.setForeground(Color.WHITE);
		btnCredits.setContentAreaFilled(false);
		btnCredits.setBorder(null);
		btnCredits.setBounds(820, 560, 225, 80);
		btnCredits.addActionListener( new MainMenuListener());
		btnCredits.setToolTipText("Look who we are!");
		add(btnCredits);
		
		// Sucoder Logo
		sucoderLogo = new JLabel();																							
		sucoderLogo.setBounds(633, 11, 582, 193);	
		add(sucoderLogo);
		
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
		
		// Background Image
		mainBackground = new JLabel("");																					
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		// Buffering images with Exceptions
		try {																												
			btnStart.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));		//Start button icon when mouse entered 
			btnStart.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));					//Start button icon 
			btnHowToPlay.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));	//How to Play button icon when mouse entered 
			btnHowToPlay.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));				//How to Play button icon 
			btnHighScores.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));	//High Scores button icon when mouse entered 
			btnHighScores.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));				//High Scores button icon 
			btnOptions.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));		//Options button icon when mouse entered 
			btnOptions.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));					//Options button icon 
			btnCredits.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));		//Credits button icon when mouse entered 
			btnCredits.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));					//Credits button icon 
			sucoderLogo.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/sucoder.png")));				//Sucoder Logo (png-transparent)
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));	//
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));			
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));	
		}catch (NullPointerException e2) {
		}
	}
}
