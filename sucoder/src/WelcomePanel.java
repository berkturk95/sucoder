/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Panel that comes first when the program starts (welcome), and contains labels
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
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WelcomePanel extends JPanel{
	
	//Components
	public JLabel versionNumber, welcomeBackground, sucoderLogo, teamName, pressLabel;
	
	public WelcomePanel(){
		// Panel Properties
		setBounds(0, 0, 1274, 691);
		setLayout(null);
		
		//Sucoder Logo 
		sucoderLogo = new JLabel("");																
		sucoderLogo.setBounds(355, 26, 564, 166);
		add(sucoderLogo);
		
		//Version Number Label
		versionNumber = new JLabel("v 1.2");														
		versionNumber.setForeground(Color.WHITE);
		versionNumber.setFont(new Font("Chalkduster", Font.BOLD, 25));
		versionNumber.setBounds(26, 626, 85, 44);
		add(versionNumber);
		
		//Team Name
		teamName = new JLabel("CodeBenders 2014");													
		teamName.setForeground(Color.WHITE);
		teamName.setFont(new Font("Chalkduster", Font.BOLD, 25));
		teamName.setBounds(957, 626, 284, 44);
		add(teamName);
		
		//'Press any key' label
		pressLabel = new JLabel("Press Any Key to Continue...");									
		pressLabel.setForeground(Color.WHITE);
		pressLabel.setFont(new Font("Chalkduster", Font.BOLD, 33));
		pressLabel.setBounds(360, 500, 590, 48);
		add(pressLabel);
		
		//welcome Background
		welcomeBackground = new JLabel("");															
		welcomeBackground.setBounds(0, 0, 1274, 691);
		add(welcomeBackground);
		
		//Buffering images with exception
		try {
			sucoderLogo.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/sucoder.png")));	
			welcomeBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/welcomebackground.jpg")));
		}catch (NullPointerException e2) {
		}
	}
}