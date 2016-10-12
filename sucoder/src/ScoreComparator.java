/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Compares the two integers
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required library for this class
import java.util.Comparator;

public class ScoreComparator implements Comparator<HighScore> {  //Comparator
	
	//compare method
	public int compare(HighScore score1, HighScore score2) 	{
		//Compares Two scores
		int sc1 = score1.getScore();
		int sc2 = score2.getScore();
    
		if (sc1 > sc2){
			return -1;
		}
		else if (sc1 < sc2){
			return 1;
		}
		else{
			return 0;
		}
    }
}