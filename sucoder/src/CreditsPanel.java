/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Credits Panel includes authors names
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
public class CreditsPanel extends JPanel{
	
	//Variables and components
	JLabel mainBackground;
	static JButton backButton;
	static JToggleButton toggleButtonMusic;
	JLabel labelCredits ,labelBugra, labelUgur, labelOnur, labelMustafa, labelBerk, labelTeam;
	
	public CreditsPanel(){
		
		// Panel Properties
		setBounds(0, 0, 1274, 691);
		setLayout(null);
			
		// Credits Label
		labelCredits = new JLabel("Credits");
		labelCredits.setForeground(new Color(233, 63, 51));
		labelCredits.setFont(new Font("Chalkduster", Font.BOLD, 60));
		labelCredits.setHorizontalAlignment(SwingConstants.CENTER);
		labelCredits.setBounds(805, 80, 273, 50);
		add(labelCredits);
		
		// Name Label
		labelBerk = new JLabel("Berk Türk");
		labelBerk.setHorizontalAlignment(SwingConstants.CENTER);
		labelBerk.setForeground(new Color(0, 0, 0));
		labelBerk.setFont(new Font("Chalkduster", Font.BOLD, 32));
		labelBerk.setBounds(760, 180, 368, 50);
		add(labelBerk);
		
		// Name Label
		labelBugra = new JLabel("Bugra Felekoglu");
		labelBugra.setHorizontalAlignment(SwingConstants.CENTER);
		labelBugra.setForeground(new Color(0, 0, 0));
		labelBugra.setFont(new Font("Chalkduster", Font.BOLD, 32));
		labelBugra.setBounds(760, 250, 368, 50);
		add(labelBugra);
		
		// Name Label
		labelMustafa = new JLabel("Mustafa Fidan");
		labelMustafa.setHorizontalAlignment(SwingConstants.CENTER);
		labelMustafa.setForeground(new Color(0, 0, 0));
		labelMustafa.setFont(new Font("Chalkduster", Font.BOLD, 32));
		labelMustafa.setBounds(760, 320, 368, 50);
		add(labelMustafa);
		
		// Name Label
		labelOnur = new JLabel("Onur Soyaslan");
		labelOnur.setHorizontalAlignment(SwingConstants.CENTER);
		labelOnur.setForeground(new Color(0, 0, 0));
		labelOnur.setFont(new Font("Chalkduster", Font.BOLD, 32));
		labelOnur.setBounds(760, 390, 368, 50);
		add(labelOnur);
		
		// Name Label
		labelUgur = new JLabel("Ugur Can Uyumaz");
		labelUgur.setHorizontalAlignment(SwingConstants.CENTER);
		labelUgur.setForeground(new Color(0, 0, 0));
		labelUgur.setFont(new Font("Chalkduster", Font.BOLD, 32));
		labelUgur.setBounds(760, 460, 368, 50);
		add(labelUgur);
		
		// Name Label
		labelTeam = new JLabel("Codebenders - 2014");
		labelTeam.setHorizontalAlignment(SwingConstants.CENTER);
		labelTeam.setForeground(new Color(0, 138, 198));
		labelTeam.setFont(new Font("Chalkduster", Font.BOLD, 35));
		labelTeam.setBounds(700, 606, 520, 50);
		add(labelTeam);
		
		// Toggle Music Button 
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
		
		// Back button
		backButton = new JButton();
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1200, 11, 58, 58);
		backButton.addActionListener( new MainMenuListener());
		backButton.setToolTipText("Click to go back Main Menu");
		add(backButton);
		
		// Background
		mainBackground = new JLabel("");
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		// Buffering Images with Exception
		try {
			toggleButtonMusic.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicon.png")));
			toggleButtonMusic.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/musicoff.png")));
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/Buttons/backbutton.png")));
			mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	}
}
