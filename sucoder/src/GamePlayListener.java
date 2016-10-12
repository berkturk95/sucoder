/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Gameplay Listener, it includes Check, Hint, Save, Easy, Medium and Hard buttons on PlaySudokuPanel and Load Game Button on PlayPanel
 * 	Also class has 
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;

	public class GamePlayListener implements ActionListener, MouseListener {
	
		static int[][] gridSolver, gridBase, gridResults, gridUser, gridUsedHints;				//Matrixes are used for communicate with sudoku object
		static Sudoku sudoku = new Sudoku();													//New Sudoku object
		static int score=0, countCheck=0, countHint=0, countSec=0, temp=0, countWrongCheck=0;	//Counters
		int columnNumber, rowNumber;															//Column and row numbers for JOptionPanel
		static final String[] ROWANDCOLUMN = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };	//Number list for JOptionPanel
		private static JFileChooser chooser; 													//Chooser for load game
		private int chooserStatus;																//Status CANCEL or OK
		File folder = new File("Save Games");													//Folder that 
		static String userName, difficulty;														//Variables	
		private static int timerController = 0;													//Timer start stop controller
		Timer timer = new Timer(1000, this);;											//Timer 
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Timer ActionPerformed method
			if(e.getSource()==timer){
				if(MainFrame.playSudokuPanel.isVisible()){	//Timer does not count when the panel not visible
					countSec++;
					PlaySudokuPanel.countTimeLabel.setText("Time: "+countSec/600 + (countSec/60)%10 +":"+(countSec%60)/10+countSec%10);
				}
			}
			
			//Solve Button Action Performed Method
			if(e.getSource()==SudokuSolverPanel.btnSolve){
				gridSolver = new int[9][9];	//creates empty solver matrix
				
				//for loop for get numbers from sudoku table
				for(int i = 0; i<9; i++){
					for(int j = 0;j<9;j++){
						if(!SudokuSolverPanel.formattedTextField[i][j].getText().equals(" "))
							gridSolver[i][j] = Integer.parseInt(SudokuSolverPanel.formattedTextField[i][j].getText());	
					}
				}
				sudoku.setSolutions(0);			//clears solutions
				sudoku.setSudoku(gridSolver);	
				SucoderEngine.solve(sudoku);	//solves the written sudoku by user
				
				//Sets Text of the sudoku boxes in the panel
				if(sudoku.getSolutions()==1){
					gridSolver = sudoku.getSolvedSudoku();
					for(int i = 0; i<9; i++){
						for(int j = 0;j<9;j++)
							SudokuSolverPanel.formattedTextField[i][j].setText(gridSolver[i][j]+"");
					}
				}
				else if(sudoku.getSolutions()==0)
					JOptionPane.showMessageDialog(MainFrame.sudokuSolverPanel, "There is no solution of this Sudoku", "No Solution", JOptionPane.WARNING_MESSAGE);
				else
					JOptionPane.showMessageDialog(MainFrame.sudokuSolverPanel, "There are too many solutions of this Sudoku", "Many Solution", JOptionPane.WARNING_MESSAGE);	
			}
			
			//Clear method of sudoku table
			else if(e.getSource()==SudokuSolverPanel.btnClear){
				gridSolver = new int[9][9];
				SudokuSolverPanel.clear();
			}

			//Easy Difficulty Game Button Action Performed Method
			else if(e.getSource()==PlaySudokuPanel.btnEasy){
				countSec=0;
				PlaySudokuPanel.toggleButtonPlayPause.setSelected(false);
				PlaySudokuPanel.countTimeLabel.setVisible(true);
				PlaySudokuPanel.fakeCountTimeLabel.setVisible(false);
				PlaySudokuPanel.clear();	//Clears sudoku table
				if(timerController==0){		//Timer controller
					timer.start();
					timerController++;
				}
				//Initialize the new variables to start with clear variables
				countWrongCheck=0;
				countCheck=0;
				PlaySudokuPanel.countCheckLabel.setText("Checks: "+countCheck);
				countHint=0;
				PlaySudokuPanel.countHintLabel.setText("Hints: "+countHint);
				difficulty="easy";
				sudoku = new Sudoku();
				gridBase = new int[9][9];
				gridResults = new int[9][9];
				gridUsedHints = new int[9][9];				
				SucoderEngine.setGenSudoku(new int[9][9]);
				
				//Generates random sudoku 
				while(SucoderEngine.getGenSudoku()[8][8]==0){
					try{
						SucoderEngine.setGenSudoku(new int[9][9]);
						SucoderEngine.randSud(0,0);
					}
					catch(Exception e5){
						
					}
				}

				//Creating an easy sudoku from generated sudoku
				do{
					SucoderEngine.setBaseSudoku(new int[9][9]);
					SucoderEngine.setSolvedSudoku(SucoderEngine.getGenSudoku());
					SucoderEngine.easySudoku();
					sudoku = new Sudoku();
					sudoku.setSudoku(SucoderEngine.copy(SucoderEngine.getBaseSudoku()));
					SucoderEngine.solve(sudoku);
					}while(sudoku.getSolutions()==2);

				//Sets the created easy sudoku to the matrixes
				sudoku.setBaseSudoku(SucoderEngine.getBaseSudoku());
				gridResults = sudoku.getSolvedSudoku();
				gridBase = sudoku.getBaseSudoku();
				
				//Printing the base sudoku to sudoku table
				for(int i = 0; i<9; i++){
					for(int j = 0;j<9;j++)
						if(!(gridBase[i][j]==0)){
							PlaySudokuPanel.formattedTextField[i][j].setText(gridBase[i][j]+"");
							PlaySudokuPanel.formattedTextField[i][j].setEditable(false);
							PlaySudokuPanel.formattedTextField[i][j].setForeground(new Color(0, 101, 240));
						}		
				}
			}

			//Medium Difficulty Game Button Action Performed Method
			else if(e.getSource()==PlaySudokuPanel.btnMedium){
				countSec=0;
				PlaySudokuPanel.toggleButtonPlayPause.setSelected(false);
				PlaySudokuPanel.countTimeLabel.setVisible(true);
				PlaySudokuPanel.fakeCountTimeLabel.setVisible(false);
				PlaySudokuPanel.clear();	//Clears sudoku table
				if(timerController==0){		//Timer controller
					timer.start();
					timerController++;
				}
				//Initialize the new variables to start with clear variables
				countWrongCheck=0;
				countCheck=0;
				PlaySudokuPanel.countCheckLabel.setText("Checks: "+countCheck);
				countHint=0;
				PlaySudokuPanel.countHintLabel.setText("Hints: "+countHint);
				difficulty="medium";
				sudoku = new Sudoku();
				gridBase = new int[9][9];
				gridResults = new int[9][9];
				gridUsedHints = new int[9][9];
				SucoderEngine.setGenSudoku(new int[9][9]);
				
				//Generates random sudoku 
				while(SucoderEngine.getGenSudoku()[8][8]==0){
					try{
						SucoderEngine.setGenSudoku(new int[9][9]);
						SucoderEngine.randSud(0,0);
					}
					catch(Exception e5){
						
					}
				}

				//Creating an easy sudoku from generated sudoku
				do{
					SucoderEngine.setBaseSudoku(new int[9][9]);
					SucoderEngine.setSolvedSudoku(SucoderEngine.getGenSudoku());
					SucoderEngine.easySudoku();
					sudoku = new Sudoku();
					sudoku.setSudoku(SucoderEngine.copy(SucoderEngine.getBaseSudoku()));
					SucoderEngine.solve(sudoku);
					}while(sudoku.getSolutions()==2);

				//Sets the created easy sudoku to the matrixes
				sudoku.setBaseSudoku(SucoderEngine.getBaseSudoku());
				gridResults = sudoku.getSolvedSudoku();
				gridBase = sudoku.getBaseSudoku();
				
				//Printing the base sudoku to sudoku table
				for(int i = 0; i<9; i++){
					for(int j = 0;j<9;j++)
						if(!(gridBase[i][j]==0)){
							PlaySudokuPanel.formattedTextField[i][j].setText(gridBase[i][j]+"");
							PlaySudokuPanel.formattedTextField[i][j].setEditable(false);
							PlaySudokuPanel.formattedTextField[i][j].setForeground(new Color(0, 101, 240));
						}		
				}
			}
			
			//Hard Difficulty Game Button Action Performed Method
			else if(e.getSource()== PlaySudokuPanel.btnHard){
				countSec=0;
				PlaySudokuPanel.toggleButtonPlayPause.setSelected(false);
				PlaySudokuPanel.countTimeLabel.setVisible(true);
				PlaySudokuPanel.fakeCountTimeLabel.setVisible(false);
				PlaySudokuPanel.clear();	//Clears sudoku table
				if(timerController==0){		//Timer controller
					timer.start();
					timerController++;
				}
				//Initialize the new variables to start with clear variables
				countWrongCheck=0;
				countCheck=0;
				PlaySudokuPanel.countCheckLabel.setText("Checks: "+countCheck);
				countHint=0;
				PlaySudokuPanel.countHintLabel.setText("Hints: "+countHint);
				difficulty="hard";
				sudoku = new Sudoku();
				gridBase = new int[9][9];
				gridResults = new int[9][9];
				gridUsedHints = new int[9][9];
				SucoderEngine.setGenSudoku(new int[9][9]);
				
				//Generates random sudoku 
				while(SucoderEngine.getGenSudoku()[8][8]==0){
					try{
						SucoderEngine.setGenSudoku(new int[9][9]);
						SucoderEngine.randSud(0,0);
					}
					catch(Exception e5){
						
					}
				}

				//Creating an easy sudoku from generated sudoku
				do{
					SucoderEngine.setBaseSudoku(new int[9][9]);
					SucoderEngine.setSolvedSudoku(SucoderEngine.getGenSudoku());
					SucoderEngine.easySudoku();
					sudoku = new Sudoku();
					sudoku.setSudoku(SucoderEngine.copy(SucoderEngine.getBaseSudoku()));
					SucoderEngine.solve(sudoku);
					}while(sudoku.getSolutions()==2);

				//Sets the created easy sudoku to the matrixes
				sudoku.setBaseSudoku(SucoderEngine.getBaseSudoku());
				gridResults = sudoku.getSolvedSudoku();
				gridBase = sudoku.getBaseSudoku();
				
				//Printing the base sudoku to sudoku table
				for(int i = 0; i<9; i++){
					for(int j = 0;j<9;j++)
						if(!(gridBase[i][j]==0)){
							PlaySudokuPanel.formattedTextField[i][j].setText(gridBase[i][j]+"");
							PlaySudokuPanel.formattedTextField[i][j].setEditable(false);
							PlaySudokuPanel.formattedTextField[i][j].setForeground(new Color(0, 101, 240));
						}		
				}
			}
			
			//Hint button action performed method
			else if(e.getSource()== PlaySudokuPanel.btnHint){
				//Asks the column number of sudoku table that the user want to take hint
				String columnString = (String) JOptionPane.showInputDialog(MainFrame.playSudokuPanel, "Please choose column number of the box that you want to get solved!", "Column Number", JOptionPane.QUESTION_MESSAGE, null, ROWANDCOLUMN, ROWANDCOLUMN[0]);
				if ((columnString != null) && (columnString.length() > 0)){
					//Asks the row number of sudoku table that the user want to take hint
					String rowString = (String) JOptionPane.showInputDialog(MainFrame.playSudokuPanel, "Please choose row number of the box that you want to get solved!", "Row Number", JOptionPane.QUESTION_MESSAGE, null, ROWANDCOLUMN, ROWANDCOLUMN[0]);
					if ((rowString != null) && (rowString.length() > 0)){	//If user clik OK
						//Takes two numbers
						columnNumber = Integer.parseInt(columnString);
						rowNumber = Integer.parseInt(rowString);
						
						//Check if the button is changeable or not
						if(gridBase[rowNumber-1][columnNumber-1]!=0){		//if button is not changeable
							PlaySudokuPanel.toggleButtonPlayPause.setSelected(true);
							JOptionPane.showMessageDialog(MainFrame.playSudokuPanel, "This box is not changeable!", "Not Changeable Element", JOptionPane.WARNING_MESSAGE);
							PlaySudokuPanel.toggleButtonPlayPause.setSelected(false);
						}
						else{												//if button is changeable
							countHint++;
							PlaySudokuPanel.countHintLabel.setText("Hints: "+countHint);
							
							gridUsedHints[rowNumber-1][columnNumber-1] = gridResults[rowNumber-1][columnNumber-1];
							
							//Shows the right answer that box
							for(int i = 0; i<9; i++){
								for(int j = 0;j<9;j++)
									if(!(gridUsedHints[i][j]==0)){
										PlaySudokuPanel.formattedTextField[i][j].setText(gridUsedHints[i][j]+"");
										PlaySudokuPanel.formattedTextField[i][j].setEditable(false);
										PlaySudokuPanel.formattedTextField[i][j].setForeground(new Color(35, 131, 65));
									}		
							}
						}
					}	
				}		
			}				
			
			//Load Game button action performed method
			else if(e.getSource()==PlayPanel.btnLoadGame){
				//Creates with path /Save Games chooser
				chooser = new JFileChooser(folder);
				chooserStatus = chooser.showOpenDialog(null);
				
				if(chooserStatus!=JFileChooser.APPROVE_OPTION) {	//If user clicks CANCEL
					MainFrame.playPanel.setVisible(true);
					MainFrame.playSudokuPanel.setVisible(false);
				}
				else{												//If user chooses a load file
					PlaySudokuPanel.clear();						//Clears the sudoku table
					MainFrame.playPanel.setVisible(false);			
					MainFrame.playSudokuPanel.setVisible(true);		//Sets visible the play sudoku panel
					
					//Getting the load game and load properties of sudoku object
					try {
						File filename = chooser.getSelectedFile();
						ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
						Sudoku loadedSudoku = (Sudoku) inputStream.readObject();
						//Loading variables
						gridUser=loadedSudoku.getSudoku();
						gridBase=loadedSudoku.getBaseSudoku();
						gridResults=loadedSudoku.getSolvedSudoku();
						gridUsedHints=loadedSudoku.getHintSudoku();
						countCheck=loadedSudoku.getCheckCount();
						countWrongCheck=loadedSudoku.getWrongCheckCount();
						countHint=loadedSudoku.getHintCount();
						countSec=loadedSudoku.getSecCount();
						difficulty=loadedSudoku.getDifficulty();
						
						PlaySudokuPanel.countCheckLabel.setText("Checks: "+countCheck);
						PlaySudokuPanel.countHintLabel.setText("Hints: "+countHint);
						
						//printing the loaded base matrix
						for(int i = 0; i<9; i++){
							for(int j = 0;j<9;j++)
								if(!(gridBase[i][j]==0)){
									PlaySudokuPanel.formattedTextField[i][j].setText(gridBase[i][j]+"");
									PlaySudokuPanel.formattedTextField[i][j].setEditable(false);
									PlaySudokuPanel.formattedTextField[i][j].setForeground(new Color(0, 101, 240));
								}		
						}
						
						//printing the loaded user matrix  
						for(int i = 0; i<9; i++){
							for(int j = 0;j<9;j++)
								if(!(gridUser[i][j]==0)){
									PlaySudokuPanel.formattedTextField[i][j].setText(gridUser[i][j]+"");
								}		
						}
						
						//Printing the loaded hints
						for(int i = 0; i<9; i++){
							for(int j = 0;j<9;j++)
								if(!(gridUsedHints[i][j]==0)){
									PlaySudokuPanel.formattedTextField[i][j].setText(gridUsedHints[i][j]+"");
									PlaySudokuPanel.formattedTextField[i][j].setEditable(false);
									PlaySudokuPanel.formattedTextField[i][j].setForeground(new Color(35, 131, 65));
								}		
						}
						
						//timer continues
						if(timerController==0){
							timer.start();
							timerController++;
						}
						
						inputStream.close();
						
					} catch (FileNotFoundException e8) {
						e8.printStackTrace();
					} catch (IOException e8) {
						e8.printStackTrace();
					} catch (ClassNotFoundException e8) {
						e8.printStackTrace();
					}
				}
			}
			
			//Save Game button action performed method
			else if(e.getSource()== PlaySudokuPanel.btnSave){
				PlaySudokuPanel.toggleButtonPlayPause.setSelected(true);
				int countSecSave = countSec-1;		//Saves the timer
				String saveName = JOptionPane.showInputDialog(MainFrame.playSudokuPanel, "Please write your save file name!");
				try{
					if(!saveName.equals(null)){
						String filename ="Save Games\\"+saveName+".sud";
					
						//Takes the user inputs
						gridUser = new int[9][9];
						for(int i = 0; i<9; i++){
							for(int j = 0;j<9;j++){
								if(!PlaySudokuPanel.formattedTextField[i][j].getText().equals(" "))
									if(gridBase[i][j]==0)
										gridUser[i][j] = Integer.parseInt(PlaySudokuPanel.formattedTextField[i][j].getText());
							}
						}
						
						//Saves the variables
						sudoku.setSudoku(gridUser);
						sudoku.setBaseSudoku(gridBase);
						sudoku.setSolvedSudoku(gridResults);
						sudoku.setHintSudoku(gridUsedHints);
						sudoku.setCheckCount(countCheck);
						sudoku.setWrongCheckCount(countWrongCheck);
						sudoku.setHintCount(countHint);
						sudoku.setSecCount(countSecSave);
						sudoku.setDifficulty(difficulty);

						//Writes the save file
						try {
							ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
							outputStream.writeObject(sudoku);
							PlaySudokuPanel.toggleButtonPlayPause.setSelected(false);
							outputStream.close();
						} catch (FileNotFoundException e5) {
							e5.printStackTrace();
						} catch (IOException e5) {
							e5.printStackTrace();
						}
					}
					else{
						PlaySudokuPanel.toggleButtonPlayPause.setSelected(false);
					}
				}
				catch(Exception e7){
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent e2) {
			// Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e2) {
			// Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e2) {
			// Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e2) {		
			//Check button action performed method (when mouse pressed)
			if(e2.getSource()==PlaySudokuPanel.btnCheck){
				boolean finish=true;
				gridUser = new int[9][9];
				//Takes the users input
				for(int i = 0; i<9; i++){
					for(int j = 0;j<9;j++){
						if(!PlaySudokuPanel.formattedTextField[i][j].getText().equals(" "))
							if(gridBase[i][j]==0)
								gridUser[i][j] = Integer.parseInt(PlaySudokuPanel.formattedTextField[i][j].getText());
					}
				}
				
				//Checks the sudoku table and finds right answers
				for(int i = 0; i<9; i++){
					for(int j = 0;j<9;j++){
						if(gridBase[i][j]==0)
							if(gridUser[i][j]!=gridResults[i][j]){
								finish = false;
								break;
							}						
					}
				}
				
				if(finish==false){			//Even if one answer is false, does this  
					countCheck++;		
					PlaySudokuPanel.countCheckLabel.setText("Checks: "+countCheck);
					//Changes colors of right answers to green, wrong answers to red
					for(int i = 0; i<9; i++){
						for(int j = 0;j<9;j++){
							if(gridBase[i][j]==0){
								if(gridResults[i][j]!=gridUser[i][j]){
									PlaySudokuPanel.formattedTextField[i][j].setForeground(new Color(229, 22, 22));
									countWrongCheck++;
								}
								else
									PlaySudokuPanel.formattedTextField[i][j].setForeground(new Color(35, 131, 65));
							}
						}					
					}
				}
				else{	//If all the answers are right, does this	
					temp = countSec;
					PlaySudokuPanel.fakeCountTimeLabel.setText("Time: "+temp/600 + (temp/60)%10 +":"+(temp%60)/10+temp%10);	
					PlaySudokuPanel.countTimeLabel.setVisible(false);
					PlaySudokuPanel.fakeCountTimeLabel.setVisible(true);
					calculateScore();		//Calculates score
					JOptionPane.showMessageDialog(MainFrame.playSudokuPanel, "Congratulations! You have finished the Sudoku! Your score is " + score, "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
					userName = JOptionPane.showInputDialog(MainFrame.playSudokuPanel, "Please write your nick name to save your high score!");//Takes user name for high score
	
					try{
						if(!userName.equals(null)){		//If user write a name
							if(userName.length()>9)
								userName = userName.substring(0, 9);
							HighScoresPanel.highScoreManager.addScore(userName, score);
							Scanner fileScan=null;
							try {
								fileScan = new Scanner(new File("High Scores\\highscore.dat"));
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					        HighScoresPanel.highScoreManager = new HighscoreManager();
					        
					        while(fileScan.hasNext()){
								String name = fileScan.next();
								int score = fileScan.nextInt();
								HighScoresPanel.highScoreManager.addScore(name, score);
					        }
					        HighScoresPanel.textPaneNames.setText(HighScoresPanel.highScoreManager.getHighScore_Names());
					        HighScoresPanel.textPaneScores.setText(HighScoresPanel.highScoreManager.getHighScore_Scores());
						}
						else{							//If user clicks CANCEL
							System.exit(0);
						}
					}
					catch(Exception e72){
					}
				}	
			}
		}

		@Override
		public void mouseReleased(MouseEvent e2) {
			//Check button action performed method (when mouse released)
			if(e2.getSource()==PlaySudokuPanel.btnCheck){
				
				//When user released the check button, user inputs becomes black again
				for(int i = 0; i<9; i++){
					for(int j = 0;j<9;j++){
						if(gridBase[i][j]==0 && gridUsedHints[i][j]==0){
							if(gridResults[i][j]!=gridUser[i][j])
								PlaySudokuPanel.formattedTextField[i][j].setForeground(Color.BLACK);
							else
								PlaySudokuPanel.formattedTextField[i][j].setForeground(Color.BLACK);
						}
					}					
				}
			}
		}
		
		//Score Calculate method
		public static void calculateScore(){
			if(difficulty.equals("easy")){			//Easy score
				score = 10000 - countHint*10 - (countCheck+countWrongCheck)*50 - temp*1; 
				if(score<0)
					score=0;
			}
			else if(difficulty.equals("medium")){	//Medium score
				score = (10000 - countHint*10 - (countCheck+countWrongCheck)*50 - temp*1)*2; 
				if(score<0)
					score=0;
			}
			else{									//Hard score
				score = (10000 - countHint*10 - (countCheck+countWrongCheck)*50 - temp*1)*3; 
				if(score<0)
					score=0;
			}
		}
	}

