/**
 * @SucoderEngine.java
 * CS 102 Project 
 * High score manager class that sorts, saves and loads the high score objects
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required libraries for this class
import java.util.*;
import java.io.*;

public class HighscoreManager {
	//Variables
    private ArrayList<HighScore> scores;
    private static final String HIGHSCORE_FILE = "High Scores\\highscore.dat";
    
    //Streams
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    //Constructor
    public HighscoreManager() {
        scores = new ArrayList<HighScore>();
    }
    
    //getter
    public ArrayList<HighScore> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    
    //Sorts array list
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
    }
    
    //adds high score object to array list
    public void addScore(String name, int score) {
        loadScoreFile();
        scores.add(new HighScore(name, score));
        updateScoreFile();
    }
    
    
    //Loads high score file
	@SuppressWarnings("unchecked")
	public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<HighScore>) inputStream.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        catch (IOException e) {
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        finally
        {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }
            catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            }
        }
    }
	
	//Updates the high score file 
    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        }
        catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        }
        catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        }
        finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }
            catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }
    
    //Resets high scores
    public void resetHighScore()    {
    	scores = new ArrayList<HighScore>();
    	updateScoreFile();
    	loadScoreFile();
    }
    
    //gets only names of High scores 
    public String getHighScore_Names() {
        String highscoreString = "";
        int max = 10;

        ArrayList<HighScore> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x){
        	highscoreString += scores.get(i).getName() + "\n";
        	i++;
        }

        return highscoreString;
    }
    
    //gets only scores of High scores 
    public String getHighScore_Scores() {
        String highscoreString = "";
        int max = 10;

        ArrayList<HighScore> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x){
        	highscoreString += scores.get(i).getScore() + "\n";
        	i++;
        }
        return highscoreString;
    }
}