/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel that contains play sudoku button and solve sudoku button
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
public class StartPanel extends JPanel{
	
	//Variables and components
	JLabel mainBackground;
	static JButton backButton, playSudokuButton, sudokuSolverButton;
	static JToggleButton toggleButtonMusic;

	public StartPanel(){
		// Panel Properties
		setBounds(0, 0, 1274, 691);
		setLayout(null);
		
		// Play Sudoku Button
		playSudokuButton = new JButton("<html><center>Play<br>Sudoku!</center></html>");																
		playSudokuButton.setFocusPainted(false);
		playSudokuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playSudokuButton.setHorizontalTextPosition(SwingConstants.CENTER);
		playSudokuButton.setFont(new Font("Chalkduster", Font.BOLD, 43));
		playSudokuButton.setForeground(Color.WHITE);
		playSudokuButton.setContentAreaFilled(false);
		playSudokuButton.setBorder(null);
		playSudokuButton.setBounds(835, 133, 258, 200);
		playSudokuButton.addActionListener(new MainMenuListener());
		playSudokuButton.setToolTipText("Play Sudoku!");
		add(playSudokuButton);	
		
		// Sudoku Solver Button
		sudokuSolverButton = new JButton("<html><center>Sudoku<br>Solver!</center></html>");									
		sudokuSolverButton.setFocusPainted(false);
		sudokuSolverButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sudokuSolverButton.setHorizontalTextPosition(SwingConstants.CENTER);
		sudokuSolverButton.setFont(new Font("Chalkduster", Font.BOLD, 43));
		sudokuSolverButton.setForeground(Color.WHITE);
		sudokuSolverButton.setContentAreaFilled(false);
		sudokuSolverButton.setBorder(null);
		sudokuSolverButton.setBounds(835, 344, 258, 200);
		sudokuSolverButton.addActionListener(new GameSelectListener());
		sudokuSolverButton.setToolTipText("Open Sudoku Solver!");
		add(sudokuSolverButton);	
		
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
		
		// Back Button
		backButton = new JButton();																								
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1200, 11, 58, 58);
		backButton.addActionListener(new MainMenuListener());
		backButton.setToolTipText("Click to go back Main Menu");
		add(backButton);
		
		// Panel Background
		mainBackground = new JLabel("");																						
		mainBackground.setBounds(0, 0, 1274, 691);	
		add(mainBackground);
		
		// Buffering images with Exceptions
		try {																													
			playSudokuButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbigbutton2.png")));
			playSudokuButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/bigbutton2.png")));
			sudokuSolverButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbigbutton2.png")));
			sudokuSolverButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/bigbutton2.png")));
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));			
		}catch (NullPointerException e2) {
		}
	}
}
