/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel class that contains musics and music album covers
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
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("serial")
public class MusicsPanel extends JPanel{
	
	//Variables and components
	JLabel mainBackground;
	static JButton backButton, buttonMusic1, buttonMusic2, buttonMusic3 ;
	static JToggleButton toggleButtonMusic;
	JLabel labelMusics;
	
	public MusicsPanel(){
		// Music Panel Properties
		setBounds(0, 0, 1274, 691);
		setLayout(null);
		
		// First Music Button
		buttonMusic1 = new JButton();
		buttonMusic1.setForeground(new Color(0, 191, 255));
		buttonMusic1.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonMusic1.setFocusPainted(false);
		buttonMusic1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonMusic1.setContentAreaFilled(false);
		buttonMusic1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonMusic1.setBounds(873, 158, 148, 148);
		buttonMusic1.addActionListener( new MusicListener());
		buttonMusic1.setToolTipText("Play \"Death of a Martian\" from RHCP");
		add(buttonMusic1);
		
		// Second Music Button
		buttonMusic2 = new JButton();
		buttonMusic2.setForeground(new Color(0, 191, 255));
		buttonMusic2.setBounds(873, 317, 148, 148);
		buttonMusic2.setFocusPainted(false);
		buttonMusic2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonMusic2.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonMusic2.setContentAreaFilled(false);
		buttonMusic2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonMusic2.addActionListener( new MusicListener());
		buttonMusic2.setToolTipText("Play \"Adventures of Rain Dance Maggie\" from RHCP");
		add(buttonMusic2);
		
		// Third Music Button
		buttonMusic3 = new JButton();
		buttonMusic3.setForeground(new Color(0, 191, 255));
		buttonMusic3.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonMusic3.setFocusPainted(false);
		buttonMusic3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonMusic3.setContentAreaFilled(false);
		buttonMusic3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonMusic3.setBounds(873, 476, 148, 148);
		buttonMusic3.addActionListener( new MusicListener());
		buttonMusic3.setToolTipText("Play \"On Mercury\" from RHCP");
		add(buttonMusic3);
		
		// 'Musics' Label
		labelMusics = new JLabel("Musics");
		labelMusics.setForeground(new Color(233, 63, 51));
		labelMusics.setFont(new Font("Chalkduster", Font.BOLD, 80));
		labelMusics.setHorizontalAlignment(SwingConstants.CENTER);
		labelMusics.setBounds(755, 39, 371, 91);
		add(labelMusics);
		
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
		
		// Back Button returns to Options Panel
		backButton = new JButton();
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1200, 11, 58, 58);
		backButton.addActionListener( new MainMenuListener());
		backButton.setToolTipText("Click to go back Options");
		add(backButton);
		
		// Panel Background
		mainBackground = new JLabel("");
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		// Buffering images with Exceptions
		try {
			buttonMusic1.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/rhcp1.png")));
			buttonMusic1.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Background/rollrhcp1.jpg")));
			buttonMusic2.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/rhcp2.png")));
			buttonMusic2.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Background/rollrhcp2.jpg")));
			buttonMusic3.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/rhcp3.png")));
			buttonMusic3.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Background/rollrhcp3.jpg")));
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	}
}
