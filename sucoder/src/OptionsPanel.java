/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel that contains options buttons
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
public class OptionsPanel extends JPanel{

	//Variables and components
	JLabel mainBackground;
	static JButton backButton, btnMusics, btnThemes;
	static JToggleButton toggleButtonMusic;
	JLabel labelOptions;
	
	public OptionsPanel(){
		// Panel Properties
		setBounds(0, 0, 1274, 691);																										// Options Panel Properties
		setLayout(null);
		
		//Title
		labelOptions = new JLabel("Options");																							// Options Label
		labelOptions.setForeground(new Color(233, 63, 51));
		labelOptions.setFont(new Font("Chalkduster", Font.BOLD, 60));
		labelOptions.setHorizontalAlignment(SwingConstants.CENTER);
		labelOptions.setBounds(800, 146, 273, 70);
		add(labelOptions);

		//Themes Button
		btnThemes = new JButton("Themes");																								// Themes Button
		btnThemes.setBounds(827, 265, 225, 80);
		btnThemes.setFocusPainted(false);
		btnThemes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThemes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnThemes.setFont(new Font("Chalkduster", Font.BOLD, 32));
		btnThemes.setForeground(Color.WHITE);
		btnThemes.setContentAreaFilled(false);
		btnThemes.setBorder(null);
		btnThemes.addActionListener( new MainMenuListener());
		btnThemes.setToolTipText("Choose a theme");
		add(btnThemes);
		
		//Musics button
		btnMusics = new JButton("Musics");																								// Musics Button
		btnMusics.setBounds(827, 380, 225, 80);
		btnMusics.setFocusPainted(false);
		btnMusics.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMusics.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMusics.setFont(new Font("Chalkduster", Font.BOLD, 32));
		btnMusics.setForeground(Color.WHITE);
		btnMusics.setContentAreaFilled(false);
		btnMusics.addActionListener( new MainMenuListener());
		btnMusics.setBorder(null);
		btnThemes.setToolTipText("Choose a music");
		add(btnMusics);
		
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
		
		//Back button
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
		mainBackground = new JLabel("");																								// Background Label
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		//Buffering images with exception
		try {																															// Exceptions	
			btnThemes.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));
			btnThemes.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));
			btnMusics.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbutton2.png")));
			btnMusics.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/button2.png")));
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	}
}
