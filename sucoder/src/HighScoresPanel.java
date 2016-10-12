/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel that contains high scores
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
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class HighScoresPanel extends JPanel{
	
	//Variables and components
	JLabel mainBackground;																											
	static JButton backButton, btnClear;
	static JToggleButton toggleButtonMusic;
	static String userName;
	JLabel labelHighScores;
	static JTextPane textPaneNumbers, textPaneNameScore, textPaneNames, textPaneScores;
	static HighscoreManager highScoreManager;
	
	public HighScoresPanel() throws IOException{
		
		//Setting bounds and layout
		setBounds(0, 0, 1274, 691);																									// High Score Panel Properties
		setLayout(null);
			
		//Title High Score
		labelHighScores = new JLabel("High Scores");																				// 'High Scores' Label
		labelHighScores.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelHighScores.setHorizontalTextPosition(SwingConstants.CENTER);
		labelHighScores.setHorizontalAlignment(SwingConstants.CENTER);
		labelHighScores.setForeground(new Color(233, 63, 51));
		labelHighScores.setFont(new Font("Chalkduster", Font.BOLD, 50));
		labelHighScores.setBounds(803, 62, 371, 74);
		add(labelHighScores);
		
		//Scans High score file
		@SuppressWarnings("resource")													
		Scanner fileScan = new Scanner(new File("High Scores\\highscore.dat"));														// HighScores File Scanner
        highScoreManager = new HighscoreManager();
        
        //Takes the names and scores from highscore file with exception
        try{
        	while(fileScan.hasNext()){
        		String name = fileScan.next();
        		int score = fileScan.nextInt();
        		highScoreManager.addScore(name, score);
        	}
        }catch(Exception e5){        	
        } 
        
        //Names of users
		textPaneNames = new JTextPane();																							// Names' Text Pane
		textPaneNames.setForeground(new Color(0, 51, 102));
		textPaneNames.setText(highScoreManager.getHighScore_Names());
		textPaneNames.setFont(new Font("Chalkduster", Font.BOLD, 30));
		textPaneNames.setOpaque(false);
		textPaneNames.setBounds(815, 195, 196, 396);
		add(textPaneNames);
		
		//Scores of users
		textPaneScores = new JTextPane();																							// Scores' Text Pane
		textPaneScores.setForeground(new Color(0, 51, 102));
		textPaneScores.setText(highScoreManager.getHighScore_Scores());
		textPaneScores.setFont(new Font("Chalkduster", Font.BOLD, 30));
		textPaneScores.setOpaque(false);
		textPaneScores.setBounds(1033, 195, 196, 396);
		add(textPaneScores);
		
		//First Title
		textPaneNumbers = new JTextPane();																							// Numbers' Text Pane
		textPaneNumbers.setFont(new Font("Chalkduster", Font.BOLD, 30));
		textPaneNumbers.setOpaque(false);
		textPaneNumbers.setText(" 1.\r\n 2.\r\n 3.\r\n 4.\r\n 5.\r\n 6.\r\n 7.\r\n 8.\r\n 9.\r\n10.");
		textPaneNumbers.setBounds(750, 196, 70, 418);
		add(textPaneNumbers);
		
		//Second Title
		textPaneNameScore = new JTextPane();																						//  Name & Score Header Text Pane
		textPaneNameScore.setText("Name\t\tScore");
		textPaneNameScore.setOpaque(false);
		textPaneNameScore.setFont(new Font("Chalkduster", Font.BOLD, 38));
		textPaneNameScore.setBounds(815, 146, 371, 57);
		add(textPaneNameScore);
		
		//Clear button that cleans high score file and refreshes the textPane 
		btnClear = new JButton("Clear Scores");																						// Clear Scores Button
		btnClear.setFocusPainted(false);
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClear.setFont(new Font("Chalkduster", Font.BOLD, 26));
		btnClear.setForeground(Color.WHITE);
		btnClear.setContentAreaFilled(false);
		btnClear.setBorder(null);
		btnClear.setBounds(870, 593, 225, 80);
		btnClear.addActionListener( new MainMenuListener());
		btnClear.setToolTipText("Click to clear Highscore Table");
		add(btnClear);
		
		// Music On/Off Quick Button
		toggleButtonMusic = new JToggleButton();																					// Music On/Off Quick Button
		toggleButtonMusic.setFocusPainted(false);
		toggleButtonMusic.setSelected(true);
		toggleButtonMusic.setBorder(null);
		toggleButtonMusic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toggleButtonMusic.setContentAreaFilled(false);
		toggleButtonMusic.setBounds(25, 11, 55, 55);
		toggleButtonMusic.addItemListener( new MusicIconListener());
		toggleButtonMusic.setToolTipText("Click to Stop Music");
		add(toggleButtonMusic);
		
		//Back button
		backButton = new JButton();																									// Back Button goes to Main Menu
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1200, 11, 58, 58);
		backButton.addActionListener( new MainMenuListener());
		backButton.setToolTipText("Click to Go Back Main Menu");
		add(backButton);
		
		//Background
		mainBackground = new JLabel();																								// Panel Background Label
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		//Buffering images with Exception
		try {																														// Exceptions
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			btnClear.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));
			btnClear.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	}
}
