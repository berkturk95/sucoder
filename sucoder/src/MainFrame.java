/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Main class that contains a frame constructor and main method
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required libraries for this class
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	//Variables and Components
	static JFrame frame;
	static JPanel contentPane;
	static WelcomePanel welcomePanel;
	static MainMenuPanel mainMenuPanel;
	static StartPanel startPanel;
	static HowToPlayPanel howToPlayPanel;
	static HighScoresPanel highScoresPanel;
	static OptionsPanel optionsPanel;
	static CreditsPanel creditsPanel;
	static ThemesPanel themesPanel;
	static MusicsPanel musicsPanel;
	static PlayPanel playPanel;
	static PlaySudokuPanel playSudokuPanel;
	static SudokuSolverPanel sudokuSolverPanel;
	static AudioClip current; 
	static URL music1 = null, music2 = null, music3 = null;
	
	//Main Method
	public static void main(String[] args) throws IOException{
		//Adding Frame
		frame = new MainFrame();
		frame.setVisible(true);
		
		//Catching musics from Musics file
		try {
			music1 = new URL("file", "localhost", "Musics\\Martian.wav");
			music2 = new URL("file", "localhost", "Musics\\Maggie.wav");
			music3 = new URL("file", "localhost", "Musics\\Mercury.wav");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//Starts the music
		current = JApplet.newAudioClip(music1);	
	}
	
	//Main Frame Constructor
	public MainFrame() throws IOException{
		//Takes program icon
		try {	
			setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/ProgramIcons/programicon.png")));
		} catch (NullPointerException e2) {
		}
		//Frame Properties
		setTitle("Sucoder");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		
		//Content Pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 1280, 720));
		contentPane.setLayout(null);
		
		//Initialize Panels
		welcomePanel = new WelcomePanel();
		mainMenuPanel = new MainMenuPanel();
		startPanel = new StartPanel();
		howToPlayPanel = new HowToPlayPanel();
		highScoresPanel = new HighScoresPanel(); 
		optionsPanel = new OptionsPanel();
		creditsPanel = new CreditsPanel();
		themesPanel = new ThemesPanel();
		musicsPanel = new MusicsPanel();
		playPanel = new PlayPanel();
		playSudokuPanel = new PlaySudokuPanel();
		sudokuSolverPanel = new SudokuSolverPanel();
		
		//Sets the visibility of panels
		welcomePanel.setVisible(true);
		mainMenuPanel.setVisible(false);
		startPanel.setVisible(false);
		howToPlayPanel.setVisible(false);
		highScoresPanel.setVisible(false);
		optionsPanel.setVisible(false);
		creditsPanel.setVisible(false);
		themesPanel.setVisible(false);
		musicsPanel.setVisible(false);
		playPanel.setVisible(false);
		playSudokuPanel.setVisible(false);
		sudokuSolverPanel.setVisible(false);
		
		//Adding panels to the frame
		setContentPane(contentPane);
		getContentPane().add(welcomePanel);
		getContentPane().add(mainMenuPanel);
		getContentPane().add(startPanel);
		getContentPane().add(howToPlayPanel);
		getContentPane().add(highScoresPanel);
		getContentPane().add(optionsPanel);
		getContentPane().add(creditsPanel);
		getContentPane().add(themesPanel);
		getContentPane().add(musicsPanel);
		getContentPane().add(playPanel);
		getContentPane().add(playSudokuPanel);
		getContentPane().add(sudokuSolverPanel);
		addKeyListener(new KeyPressListener());		//Adds key press listener to the frame
	}
}
