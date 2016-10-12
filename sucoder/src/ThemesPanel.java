/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel that contains Themes and Mini theme labels
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
public class ThemesPanel extends JPanel{
	
	JLabel mainBackground;
	static JButton backButton, buttonTheme1, buttonTheme2, buttonTheme3 ;
	static JToggleButton toggleButtonMusic;
	JLabel labelThemes;
	
	public ThemesPanel(){

		setBounds(0, 0, 1274, 691);
		setLayout(null);
		
		// First Theme Button
		buttonTheme1 = new JButton();
		buttonTheme1.setForeground(new Color(0, 191, 255));
		buttonTheme1.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonTheme1.setFocusPainted(false);
		buttonTheme1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonTheme1.setContentAreaFilled(false);
		buttonTheme1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonTheme1.setBounds(817, 158, 260, 148);
		buttonTheme1.addActionListener( new BackgroundListener());
		buttonTheme1.setToolTipText("Choose Theme 1");
		add(buttonTheme1);
		
		// Second Theme Button
		buttonTheme2 = new JButton();
		buttonTheme2.setForeground(new Color(0, 191, 255));
		buttonTheme2.setBounds(817, 317, 260, 148);
		buttonTheme2.setFocusPainted(false);
		buttonTheme2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonTheme2.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonTheme2.setContentAreaFilled(false);
		buttonTheme2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonTheme2.addActionListener( new BackgroundListener());
		buttonTheme2.setToolTipText("Choose Theme 2");
		add(buttonTheme2);
		
		// Third Theme Button
		buttonTheme3 = new JButton();
		buttonTheme3.setForeground(new Color(0, 191, 255));
		buttonTheme3.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonTheme3.setFocusPainted(false);
		buttonTheme3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonTheme3.setContentAreaFilled(false);
		buttonTheme3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonTheme3.setBounds(817, 476, 260, 148);
		buttonTheme3.addActionListener( new BackgroundListener());
		buttonTheme3.setToolTipText("Choose Theme 3");
		add(buttonTheme3);
		
		// 'Themes' Label
		labelThemes = new JLabel("Themes");
		labelThemes.setForeground(new Color(233, 63, 51));
		labelThemes.setFont(new Font("Chalkduster", Font.BOLD, 80));
		labelThemes.setHorizontalAlignment(SwingConstants.CENTER);
		labelThemes.setBounds(755, 39, 371, 91);
		add(labelThemes);
		
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
		
		// Background Label
		mainBackground = new JLabel("");
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		//Exceptions
		try {
			buttonTheme1.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/thumbnail1.jpg")));
			buttonTheme1.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Background/rollthumbnail1.jpg")));
			buttonTheme2.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/thumbnail2.jpg")));
			buttonTheme2.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Background/rollthumbnail2.jpg")));
			buttonTheme3.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/thumbnail3.jpg")));
			buttonTheme3.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Background/rollthumbnail3.jpg")));
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));			
		}catch (NullPointerException e2) {
		}
	}
}
