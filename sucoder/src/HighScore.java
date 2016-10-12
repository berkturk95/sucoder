/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Highscore object class
 * @Codebenders		Berk T�rk
 * 					Bu�ra Feleko�lu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					U�ur Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required libraries for this class
import java.io.Serializable;

@SuppressWarnings("serial")
public class HighScore implements Serializable {
	//name and score variables
    private int score;
    private String name;

    //Getters
    public int getScore() {
        return score;
    }

    //Getters	
    public String getName() {
        return name;
    }
    
    //setter
    public HighScore(String name, int score) {
        this.score = score;
        this.name = name;
    }
}
