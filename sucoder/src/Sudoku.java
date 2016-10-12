/**
 * @SucoderEngine.java
 * CS 102 Project 
 * Sudoku class to hold unsolved, solved sudokus
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required library for this class
import java.io.Serializable;

@SuppressWarnings("serial")
public class Sudoku implements Serializable{
	//Holds solved, unsolved sudoku and other necessary sudokus, solutions and counts
	private int[][] sudoku;
	private int[][] baseSudoku;
	private int[][] solvedSudoku;
	private int[][] hintSudoku;
	private int solutions, countCheck, countHint, countSec, countWrongCheck;
	private String difficulty;
	//Creates the sudokus and initiliazed int variables
    public Sudoku() {
    	sudoku = new int[9][9];
    	baseSudoku = new int[9][9];
    	solvedSudoku = new int[9][9];
    	hintSudoku = new int[9][9];
    	countWrongCheck = 0;
    	countCheck = 0;
    	countHint = 0;
    	countSec = 0;
    	solutions = 0;
    }
  //Getters and Setters
	public int[][] getSudoku(){
		return sudoku;
	}
	public void setSudoku(int[][] sudoku){
		this.sudoku = sudoku;
	}
	public int[][] getSolvedSudoku(){
		return solvedSudoku;
	}
	public void setSolvedSudoku(int[][] solvedSudoku){
		this.solvedSudoku = solvedSudoku;
	}
	public int getSolutions(){
		return solutions;
	}
	public void setSolutions(int solutions){
		this.solutions = solutions;
	}
	public int getCheckCount(){
		return countCheck;
	}
	public void setCheckCount(int countCheck){
		this.countCheck = countCheck;
	}
	public int getWrongCheckCount(){
		return countWrongCheck;
	}
	public void setWrongCheckCount(int countWrongCheck){
		this.countWrongCheck = countWrongCheck;
	}
	public int getHintCount(){
		return countHint;
	}
	public void setHintCount(int countHint){
		this.countHint = countHint;
	}
	public int getSecCount(){
		return countSec;
	}
	public void setSecCount(int countSec){
		this.countSec = countSec;
	}
	public String getDifficulty(){
		return difficulty;
	}
	public void setDifficulty(String difficulty){
		this.difficulty = difficulty;
	}
	public int[][] getBaseSudoku(){
		return baseSudoku;
	}
	public void setBaseSudoku(int[][] baseSudoku){
		this.baseSudoku = baseSudoku;
	}
	public int[][] getHintSudoku(){
		return hintSudoku;
	}
	public void setHintSudoku(int[][] hintSudoku){
		this.hintSudoku = hintSudoku;
	}
}