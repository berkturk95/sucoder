/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel that contains sudoku table, solve and clear button
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
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class SudokuSolverPanel extends JPanel{

	JLabel mainBackground, sudokuBackground;
	static JButton backButton, btnSolve, btnClear, buttonMusic1, buttonMusic2, buttonMusic3;
	static JToggleButton toggleButtonMusic;
	static JFormattedTextField[][] formattedTextField;
	static MaskFormatter integerFormatter;
	static DefaultFormatterFactory integerFormatterFactory;
		
	public SudokuSolverPanel(){

		setBounds(0, 0, 1274, 691);
		setLayout(null);
		
		integerFormatter = null;
		try {
			integerFormatter = new MaskFormatter("*");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		integerFormatter.setValidCharacters("123456789 ");
		integerFormatter.setPlaceholderCharacter(' ');     
		integerFormatter.setValueClass(String.class);   
		integerFormatterFactory = new DefaultFormatterFactory(integerFormatter);
		
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
		
		btnSolve = new JButton("Solve!");
		btnSolve.setFocusPainted(false);
		btnSolve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSolve.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSolve.setFont(new Font("Chalkduster", Font.BOLD, 36));
		btnSolve.setForeground(Color.WHITE);
		btnSolve.setContentAreaFilled(false);
		btnSolve.setBorder(null);
		btnSolve.setBounds(452, 295, 225, 80);
		btnSolve.addActionListener( new GamePlayListener());
		btnSolve.setToolTipText("Click to solve your Sudoku!");
		add(btnSolve);
		
		btnClear = new JButton("Clear");
		btnClear.setFocusPainted(false);
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClear.setFont(new Font("Chalkduster", Font.BOLD, 36));
		btnClear.setForeground(Color.WHITE);
		btnClear.setContentAreaFilled(false);
		btnClear.setBorder(null);
		btnClear.setBounds(452, 405, 225, 80);
		btnClear.addActionListener( new GamePlayListener());
		btnClear.setToolTipText("Click to clear Sudoku Table");
		add(btnClear);
		
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
		
		// Music On/Off Quick Button
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
		
		//Back Button
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
		 
		//Sudoku Table Backgorund
		sudokuBackground = new JLabel("");
		sudokuBackground.setBounds(692, 111, 555, 555);
		add(sudokuBackground);
		
		//Background
		mainBackground = new JLabel("");
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		//Buffering images with Exception
		try {
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			btnSolve.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));
			btnSolve.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));
			btnClear.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));
			btnClear.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			buttonMusic1.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollmusic1.png")));
			buttonMusic1.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/music1.png")));
			buttonMusic2.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollmusic2.png")));
			buttonMusic2.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/music2.png")));
			buttonMusic3.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollmusic3.png")));
			buttonMusic3.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/music3.png")));
			sudokuBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/sudokubackground.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	}
	
	public static void clear(){
		for(int i = 0; i<9; i++){
			for(int j = 0;j<9;j++)
				formattedTextField[i][j].setValue(" ");
		}
	}
}
