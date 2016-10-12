/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel that contains sudoku table, sudoku boxes and various buttons
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required libraries for this class
import java.awt.Cursor;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

@SuppressWarnings("serial")
public class PlaySudokuPanel extends JPanel{

	//Variables and components
	JLabel mainBackground, sudokuBackground;
	static JLabel countCheckLabel, countHintLabel, countTimeLabel, labelNote, sudokuPausedBackground, fakeCountTimeLabel;
	static JButton backButton, btnEasy, btnMedium, btnHard, btnCheck, btnHint, btnSave, buttonMusic1, buttonMusic2, buttonMusic3;
	static JToggleButton toggleButtonMusic, toggleButtonPlayPause;
	static MaskFormatter integerFormatter;
	static JFormattedTextField[][] formattedTextField;
	static DefaultFormatterFactory integerFormatterFactory;
	JLabel userNameLabel;
	
	public PlaySudokuPanel(){
		// Panel Properties
		setBounds(0, 0, 1274, 691);
		setLayout(null);
		
		//Sudoku Table Paused
		sudokuPausedBackground = new JLabel("");
		sudokuPausedBackground.setBounds(692, 111, 555, 555);
		sudokuPausedBackground.setVisible(false);
		add(sudokuPausedBackground);
		
		//Setting the text field formatter
		integerFormatter=null;
		try {
			integerFormatter = new MaskFormatter("*");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		integerFormatter.setValidCharacters("123456789 ");		//Choosing valid characters for sudoku boxes
		integerFormatter.setPlaceholderCharacter(' ');     
		integerFormatter.setValueClass(String.class);   
		integerFormatterFactory = new DefaultFormatterFactory(integerFormatter);
		
		//Initializing Sudoku boxes as the sudoku table
		formattedTextField = new JFormattedTextField[9][9];
		for(int i = 0; i<9; i++){
			for(int j = 0;j<9;j++){
				formattedTextField[i][j] = new JFormattedTextField();
				formattedTextField[i][j].setOpaque(false);
				formattedTextField[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
				formattedTextField[i][j].setFont(new Font("Chalkduster", Font.BOLD, 40));
				formattedTextField[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				formattedTextField[i][j].setBorder(null);
				formattedTextField[i][j].setBounds(700+j*60, 120+i*60, 60, 60);
				formattedTextField[i][j].setFormatterFactory(integerFormatterFactory);
				add(formattedTextField[i][j]);
			}
		}
		
		//Easy Button
		btnEasy = new JButton("Easy");
		btnEasy.setFocusPainted(false);
		btnEasy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEasy.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEasy.setFont(new Font("Chalkduster", Font.BOLD, 38));
		btnEasy.setForeground(Color.WHITE);
		btnEasy.setContentAreaFilled(false);
		btnEasy.setBorder(null);
		btnEasy.setBounds(452, 350, 225, 80);
		btnEasy.addActionListener( new GamePlayListener());
		btnEasy.setToolTipText("Click to create Easy Sudoku!");
		add(btnEasy);
		
		//Medium Button
		btnMedium = new JButton("Medium");
		btnMedium.setFocusPainted(false);
		btnMedium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMedium.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMedium.setFont(new Font("Chalkduster", Font.BOLD, 34));
		btnMedium.setForeground(Color.WHITE);
		btnMedium.setContentAreaFilled(false);
		btnMedium.setBorder(null);
		btnMedium.setBounds(452, 444, 225, 80);
		btnMedium.addActionListener( new GamePlayListener());
		btnMedium.setToolTipText("Click to create Medium Sudoku!");
		add(btnMedium);
		
		//Hard Button
		btnHard = new JButton("Hard");
		btnHard.setFocusPainted(false);
		btnHard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHard.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHard.setFont(new Font("Chalkduster", Font.BOLD, 38));
		btnHard.setForeground(Color.WHITE);
		btnHard.setContentAreaFilled(false);
		btnHard.setBorder(null);
		btnHard.setBounds(452, 538, 225, 80);
		btnHard.addActionListener( new GamePlayListener());
		btnHard.setToolTipText("Click to create Hard Sudoku!");
		add(btnHard);		
		
		//Check count label
		countCheckLabel = new JLabel("Checks: 0");
		countCheckLabel.setForeground(Color.BLACK);
		countCheckLabel.setFont(new Font("Chalkduster", Font.BOLD, 25));
		countCheckLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countCheckLabel.setBounds(472, 202, 187, 39);
		add(countCheckLabel);
		
		//Hint count label
		countHintLabel = new JLabel("Hints: 0");
		countHintLabel.setForeground(Color.BLACK);
		countHintLabel.setFont(new Font("Chalkduster", Font.BOLD, 25));
		countHintLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countHintLabel.setBounds(470, 151, 157, 39);
		add(countHintLabel);
		
		//Time count label
		countTimeLabel = new JLabel("Time: 00:00");
		countTimeLabel.setForeground(Color.BLACK);
		countTimeLabel.setFont(new Font("Chalkduster", Font.BOLD, 25));
		countTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countTimeLabel.setBounds(473, 254, 195, 39);
		add(countTimeLabel);
		
		//Time count label
		fakeCountTimeLabel = new JLabel("Time: 00:00");
		fakeCountTimeLabel.setForeground(Color.BLACK);
		fakeCountTimeLabel.setFont(new Font("Chalkduster", Font.BOLD, 25));
		fakeCountTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fakeCountTimeLabel.setBounds(473, 254, 195, 39);
		fakeCountTimeLabel.setVisible(false);
		add(fakeCountTimeLabel);
		
		//Check button
		btnCheck = new JButton();
		btnCheck.setFocusPainted(false);
		btnCheck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCheck.setContentAreaFilled(false);
		btnCheck.setBorder(null);
		btnCheck.setBounds(759, 40, 60, 60);
		btnCheck.addMouseListener(new GamePlayListener());
		btnCheck.setToolTipText("<html><center>Click to check Sudoku! Also checks the final status of sudoku.<br>But be careful! Every checks decrease your score!</center></html>");
		add(btnCheck);
		
		//Hint button
		btnHint = new JButton();
		btnHint.setFocusPainted(false);
		btnHint.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHint.setContentAreaFilled(false);
		btnHint.setBorder(null);
		btnHint.setBounds(850, 38, 60, 60);
		btnHint.addActionListener(new GamePlayListener());
		btnHint.setToolTipText("Click to use Hint! But be careful because hints decrease your score!");
		add(btnHint);
		
		//Save button
		btnSave = new JButton();
		btnSave.setFocusPainted(false);
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setContentAreaFilled(false);
		btnSave.setBorder(null);
		btnSave.setBounds(941, 44, 50, 50);
		btnSave.addActionListener(new GamePlayListener());
		btnSave.setToolTipText("Click to save current Game");
		add(btnSave);
		
		//Play Pause Button
		toggleButtonPlayPause = new JToggleButton();
		toggleButtonPlayPause.setFocusPainted(false);
		toggleButtonPlayPause.setSelected(false);
		toggleButtonPlayPause.setBorder(null);
		toggleButtonPlayPause.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toggleButtonPlayPause.setContentAreaFilled(false);
		toggleButtonPlayPause.setBounds(1031, 41, 55, 55);
		toggleButtonPlayPause.addItemListener(new GamePauseListener());
		toggleButtonPlayPause.setToolTipText("Click to pause the game!");
		add(toggleButtonPlayPause);
		
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
		
		//Small change music button
		buttonMusic1 = new JButton();
		buttonMusic1.setFocusPainted(false);
		buttonMusic1.setSelected(true);
		buttonMusic1.setBorder(null);
		buttonMusic1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonMusic1.setContentAreaFilled(false);
		buttonMusic1.setBounds(86, 8, 45, 45);
		buttonMusic1.addActionListener(new MainMenuListener());
		buttonMusic1.setToolTipText("Play \"Death of a Martian\" from RHCP");
		buttonMusic1.addActionListener( new MusicListener());
		add(buttonMusic1);
		
		//Small change music button
		buttonMusic2 = new JButton();
		buttonMusic2.setSelected(true);
		buttonMusic2.setFocusPainted(false);
		buttonMusic2.setContentAreaFilled(false);
		buttonMusic2.setBorder(null);
		buttonMusic2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonMusic2.setBounds(72, 55, 45, 45);
		buttonMusic2.addActionListener(new MainMenuListener());
		buttonMusic2.setToolTipText("Play \"Adventures of Rain Dance Maggie\" from RHCP");
		buttonMusic2.addActionListener( new MusicListener());
		add(buttonMusic2);
		
		//Small change music button
		buttonMusic3 = new JButton();
		buttonMusic3.setSelected(true);
		buttonMusic3.setFocusPainted(false);
		buttonMusic3.setContentAreaFilled(false);
		buttonMusic3.setBorder(null);
		buttonMusic3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonMusic3.setBounds(26, 74, 40, 40);
		buttonMusic3.addActionListener(new MainMenuListener());
		buttonMusic3.setToolTipText("Play \"On Mercury\" from RHCP");
		buttonMusic3.addActionListener( new MusicListener());
		add(buttonMusic3);
		
		//Back button
		backButton = new JButton();
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1200, 11, 58, 58);
		backButton.addActionListener(new GameSelectListener());
		backButton.setToolTipText("Click to go back Play Menu");
		add(backButton);
		
		//Note paper label
		labelNote = new JLabel("");
		labelNote.setHorizontalAlignment(SwingConstants.CENTER);
		labelNote.setBounds(455, 105, 215, 215);
		add(labelNote);
		
		//Sudoku Table Backgorund
		sudokuBackground = new JLabel("");
		sudokuBackground.setBounds(692, 111, 555, 555);
		add(sudokuBackground);
		
		//background
		mainBackground = new JLabel("");
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		//Buffering images with Exception
		try {
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			toggleButtonPlayPause.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/play.png")));
			toggleButtonPlayPause.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/pause.png")));
			toggleButtonPlayPause.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollpause.png")));
			toggleButtonPlayPause.setRolloverSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollplay.png")));
			btnEasy.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rolleasybutton.png")));
			btnEasy.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/easybutton.png")));
			btnMedium.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollmediumbutton.png")));
			btnMedium.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/mediumbutton.png")));
			btnHard.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollhardbutton.png")));
			btnHard.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/hardbutton.png")));
			btnCheck.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollcheck.png")));
			btnCheck.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/check.png")));	
			btnHint.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollhint.png")));
			btnHint.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/hint.png")));
			btnSave.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollsave.png")));
			btnSave.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/save.png")));
			buttonMusic1.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollmusic1.png")));
			buttonMusic1.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/music1.png")));
			buttonMusic2.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollmusic2.png")));
			buttonMusic2.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/music2.png")));
			buttonMusic3.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollmusic3.png")));
			buttonMusic3.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/music3.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			labelNote.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/note.png")));
			sudokuBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/sudokubackground.png")));
			sudokuPausedBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/pausedsudoku.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	}
	
	//Clears the sudoku table 
	public static void clear(){
		for(int i = 0; i<9; i++){
			for(int j = 0;j<9;j++){
				formattedTextField[i][j].setValue(" ");
				formattedTextField[i][j].setEditable(true);
				formattedTextField[i][j].setForeground(Color.BLACK);
			}
		}
	}
}
