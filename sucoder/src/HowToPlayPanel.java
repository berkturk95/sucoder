/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel that contains information about sudoku
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
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class HowToPlayPanel extends JPanel{
	
	//Variables and components
	JLabel mainBackground;
	static JButton backButton;
	static JToggleButton toggleButtonMusic;
	JLabel labelHowToPlay;
	JTextPane textPane1, textPane2, textPane3, textPane4, textPane5;
	
	public HowToPlayPanel(){
		//Setting bounds and layout
		setBounds(0, 0, 1274, 691);
		setLayout(null);
		
		//Title
		labelHowToPlay = new JLabel("How To Play?");																					// 'How To Play' Label 
		labelHowToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		labelHowToPlay.setForeground(new Color(233, 63, 51));
		labelHowToPlay.setFont(new Font("Chalkduster", Font.BOLD, 50));
		labelHowToPlay.setBounds(721, 59, 423, 66);
		add(labelHowToPlay);
		
		//Informative text pane
		textPane1 = new JTextPane();																									// Text Pane 1
		textPane1.setText("--Sudoku is played over a 9x9 grid, divided to 3x3 sub grids called \"regions\".");
		textPane1.setFont(new Font("Chalkduster", Font.BOLD, 25));
		textPane1.setBorder(null);
		textPane1.setOpaque(false);
		textPane1.setBounds(654, 134, 577, 107);
		add(textPane1);
		
		//Informative text pane
		textPane2 = new JTextPane();																									// Text Pane 2
		textPane2.setText("--Sudoku begins with some of the grid cells already filled with numbers.");
		textPane2.setOpaque(false);
		textPane2.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane2.setBorder(null);
		textPane2.setBounds(654, 254, 577, 66);
		add(textPane2);
		
		//Informative text pane
		textPane3 = new JTextPane();																									// Text Pane 3
		textPane3.setText("--The object of Sudoku is to fill the other emtpy cells with numbers between 1 and 9 (1 number only in each cell) according the following guidelines:");
		textPane3.setOpaque(false);
		textPane3.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane3.setBorder(null);
		textPane3.setBounds(766, 326, 488, 137);
		add(textPane3);
		
		//Informative text pane
		textPane4 = new JTextPane();																									// Text Pane 4
		textPane4.setText("1)Number can appear only once on each row,\r\n2)Number can appear only once on each column,\r\n3)Number can appear only once on each region.");
		textPane4.setOpaque(false);
		textPane4.setFont(new Font("Chalkduster", Font.BOLD, 18));
		textPane4.setBorder(null);
		textPane4.setBounds(703, 473, 551, 83);	
		add(textPane4);
		
		//Informative text pane
		textPane5 = new JTextPane();																									// Text Pane 5
		textPane5.setText("--A summary of these guidelines would be, that a number should appear only once on each row, column and a region.");
		textPane5.setOpaque(false);
		textPane5.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane5.setBorder(null);
		textPane5.setBounds(703, 567, 551, 85);
		add(textPane5);
		
		// Music On/Off Quick Button
		toggleButtonMusic = new JToggleButton();																						// Music On/Off Quick Button
		toggleButtonMusic.setFocusPainted(false);
		toggleButtonMusic.setSelected(true);
		toggleButtonMusic.setBorder(null);
		toggleButtonMusic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toggleButtonMusic.setContentAreaFilled(false);
		toggleButtonMusic.setBounds(25, 11, 55, 55);
		toggleButtonMusic.addItemListener( new MusicIconListener());
		toggleButtonMusic.setToolTipText("Click to stop music");
		add(toggleButtonMusic);
		
		//Back Button
		backButton = new JButton();																										// Back Button goes to Main Menu
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1200, 11, 58, 58);
		backButton.addActionListener( new MainMenuListener());
		backButton.setToolTipText("Click to go back Main Menu");
		add(backButton);
		
		//Background
		mainBackground = new JLabel("");																								// Background
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		//Buffering images with Exception
		try {																															// Exceptions
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));						
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	}
}
