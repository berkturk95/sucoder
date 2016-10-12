/**
 * @SucoderEngine.java
 * CS 102 Project 
 * It includes the main algorithms of the program
 * @Codebenders		Berk Türk
 * 					Buðra Felekoðlu
 * 					Mustafa Fidan
 * 					Onur Soyaslan
 * 					Uður Can Uyumaz
 * 
 * @version 1.00 2014/12/23
 */

//Required libraries for this class
import java.util.ArrayList;
import java.util.Random;

public class SucoderEngine {
	private static int solutions;//Holding Sudoku solutions and is assigned into Sudoku object in solve method
	private static int[][] solvedSudoku; //Holds the solved sudoku and is assigned into Sudoku object in solve method
	private static int[][] genSudoku = new int[9][9];//Holds the generated sudoku and is assigned into Sudoku object in randSud method
	private static int[][] baseSudoku = new int[9][9];//Holds the base sudoku for user to solve and is assigned into the sudoku object
	private static boolean[][][] control = new boolean[9][9][9];//Control array for backtracking in the randSud method (The Generating sudoku method)
	private static int x,y; //Holds the last empty coordinates to make the solving algorithm more efficient

	//Copy the sudoku matrix into a new sudoku matrix
	public static int[][] copy (int[][] sudoku){
    	int[][] copy = new int[9][9];
    	for(int i = 0 ; i < 9 ; i++)
			for(int j = 0 ; j < 9 ; j++)
				copy[i][j] = sudoku[i][j];
		return copy;
    }

    //Takes the Sudoku object and starts the solving algorithm
    public static void solve(Sudoku sudoku){
    	try{
 			//Creates a matrix to hold solved sudoku and reset solutions
    		solvedSudoku = new int[9][9];
    		solutions = 0;
    		//If the written sudoku is invalid in the beginning the algorithm does not start and assigns 0 solutions and a empty matrix
    		if(check(sudoku.getSudoku())){
    			lastEmpty(sudoku.getSudoku());
    			solve(0,0,sudoku.getSudoku());
    			sudoku.setSolutions(solutions);
    			sudoku.setSolvedSudoku(solvedSudoku);
    		}
    	}
    	catch(Exception exception){
    	}
    }
    /* The solving algorithm which solves a sudoku
   	   solutions takes 2 if there are many solutions
       solutions takes 1 if there is only solution
       solutions takes 0 if there is no solution
       The recursion ends if it cannot find available number for coordinates
    */
	private static void solve( int row, int col , int[][] sud) throws Exception{
		//Recursion continues until reach border of matrix or solutions takes 2
		if(row<9 && col<9 && solutions<2){
			if( sud[row][col] != 0 )//If the tile has already a number skip the next coordinates
         		next(row,col,sud);
        	else{ //If the tile is empty
        		//Checks all possible number for the tile and every possible number creates a new sudoku and calls the method
         		for(int num = 1;num<10;num++){
            		if( rowCheck(row,num,sud) && colCheck(col,num,sud) && squareCheck(row,col,num,sud)){//Checks the numbers if it is avaible for the tile
						//Copies the sudoku and assigns the available number
						int[][] temp = copy(sud);
               			temp[row][col] = num ;
               			//If the recursion comes to the last empty tile in the sudoku checks if it is solved or not
           				if( row == x && col == y ){
			      			temp[row][col] = num ;
      						solutions++;
      						solvedSudoku = temp;
      					}
      					next(row,col,temp); //Goes next tile in the sudoku
            		}
         		}
      		}
   		}
   	}
   	//Next method for solve method
   	private static void next( int row, int col , int[][] sud ) throws Exception{
   		//If it is out of border does not go next tile
   		if(col<9 && row<9){
			//Calls solve method for next tile if tile is not end of the row
      		if( col < 8 )
         		solve( row, col + 1 , sud) ;
      		//If it is end of the row calls the method for next row
      		else
         		solve( row + 1, 0 , sud) ;
        }
  	}
  	//Check the row if there is another same number
	private static boolean rowCheck(int i, int num, int[][] sud){
		for(int j = 0; j < 9 ; j++)
			if(sud[i][j]==num)
				return false;
		return true;
	}
  	//Check the col if there is another same number
	private static boolean colCheck(int j, int num, int[][] sud){
		for(int i = 0; i < 9 ; i++)
			if(sud[i][j]==num)
				return false;
		return true;
	}
  	//Check the 9 tiles square if there is another same number
	public static boolean squareCheck(int i, int j, int num, int[][] sud){
      //Calculates which square the number is in
      i = (i/3)*3;
      j = (j/3)*3;
      //Checks the square if there is the same number
      for(int k = 0;k<3;k++)
         for(int l = 0;l<3;l++)
         	if(sud[i+k][j+l]==num)
            	return false ;
      return true ;
	}
	//Finds last empty tile for increase efficiency in the solve algorithm
	private static void lastEmpty(int[][] sud){
		for(int row = 0 ; row < 9 ; row++)
			for(int col = 0 ; col < 9 ; col++)
				if(sud[row][col]==0){
					x=row;
					y=col;
				}
	}
	//Checks a not solved sudoku whether is it proper written or not
	public static boolean check(int[][] sud){
		//Controls every non-empty tile
		for(int row = 0 ; row < 9 ; row++)
			for(int col = 0 ; col < 9 ; col++)
				if(sud[row][col]!=0){
					for(int j = 0; j < 9 ; j++){
						if(sud[row][j]==sud[row][col] && j!=col)
							return false;
					}
					for(int j = 0; j < 9 ; j++){
						if(sud[j][col]==sud[row][col] && j!=row)
							return false;
					}
					int a = (row / 3) * 3 ;
      				int b = (col / 3) * 3 ;
      				for( int r = 0; r < 3; r++ )
         				for( int c = 0; c < 3; c++ )
         					if(a+r!=row && b+c != col)
         						if(sud[a+r][b+c] == sud[row][col])
            						return false ;
				}
		return true;
	}
	//Generates a random sudoku by using recursive function and backtracking algorithm
	public static void randSud(int row, int col) throws Exception{
		//If the coordinates out of bounds then recursion will not continue
		if(row>-1 && row<9 && col>-1 && col<9){

			Random generator = new Random();

			//ArrayList holds every possible number for the tile
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			//If there is an available number adds to the arraylist
			for(int num = 1;num<10;num++){
            	if(rowCheck(row,num,genSudoku) && colCheck(col,num,genSudoku) && squareCheck(row,col,num,genSudoku) && control[row][col][num-1]==false)
					numbers.add(num);
      		}
      		//if arraylist is not empty randomly chooses a possible number from the arraylist and assigns to the genSudoku
      		if(numbers.size()!=0){
      			int random = generator.nextInt(numbers.size());
      			genSudoku[row][col] = numbers.get(random);
      			nextRand(row,col);
      		}
			//If there is not possible number recursion goes back
      		else{
      			preRand(row,col);
      		}
		}
	}
   	//Next method for randSud method
  	private static void nextRand( int row, int col) throws Exception{
   		//If the the coordinates out of bounds the method does nothing
   		if(row<9 && col<9){
   			//Calls randSud method for next tile if tile is not end of the row
    		if( col < 8 ){
    			//Because of bactracking there may some available number cannot be used. Making next tiles available number reset prevents it
    			//***Check the preRand method to understand of using the boolean***//
      			for(int i = row ; i < 9 ; i++)
					for(int j = col+1 ; j < 9 ; j++)
						for( int num = 1; num < 10; num++ )
							control[i][j][num-1]=false;
    	        randSud( row, col + 1) ;
   		   	}
   		   	//If it is end of the row calls the method for next row
    		else{
    			//Because of bactracking there may some available number cannot be used. Making next tiles available number reset prevents it
    			//***Check the preRand method to understand of using the boolean***//
      			for(int i = row+1 ; i < 9 ; i++)
					for(int j = col ; j < 9 ; j++)
						for( int num = 1; num < 10; num++ )
							control[i][j][num-1]=false;
        		randSud( row + 1, 0) ;

    		}
   		}
 	}
 	//Previous method for randSud method
   	private static void preRand( int row, int col) throws Exception{
   		//If the the coordinates out of bounds the method does nothing
   		if(row>-1 && col>-1){
   			//Calls randSud method for previous tile if tile is not begin of the row
      		if( col > 1 ){
      			/* Makes the previous coordinates of value cannot used and clears the tile
      			   The number cannot be selected again and there will be different probability */
      			control[row][col-1][genSudoku[row][col-1]-1]=true;
      			genSudoku[row][col-1]=0;
      			//Goes previous tile
      			randSud( row, col - 1) ;
      		}
   			//Calls randSud method for previous tile if tile is begin of the row
      		else{
      			/* Makes the previous coordinates of value cannot used and clears the tile
      			   The number cannot be selected again and there will be different probability */
      			control[row-1][col][genSudoku[row-1][col]-1]=true;
      			genSudoku[row-1][col]=0;
      			//Goes previous tile
       			randSud( row - 1, 0) ;
      		}
   		}
   	}
   	//Creates an easy unsolved Sudoku from a full Sudoku
   	public static void easySudoku(){
		Random generator = new Random();
		int num = generator.nextInt(14)+36;
		int row,col;
		//The loop will continue until there are "num" filled tiles
		for(int i = 0; i<num; i++){
			row = generator.nextInt(9);
			col = generator.nextInt(9);
			if(baseSudoku[row][col]==0)
				baseSudoku[row][col]=solvedSudoku[row][col];
			else
				i--;
		}
   	}
   	//Creates a medium unsolved Sudoku from a full Sudoku
   	public static void mediumSudoku(){
		Random generator = new Random();
		int num = generator.nextInt(4)+32;
		int row,col;
		//The loop will continue until there are "num" filled tiles
		for(int i = 0; i<num; i++){
			row = generator.nextInt(9);
			col = generator.nextInt(9);
			if(baseSudoku[row][col]==0)
				baseSudoku[row][col]=solvedSudoku[row][col];
			else
				i--;
		}
   	}
   	//Creates a hard unsolved Sudoku from a full Sudoku
   	public static void hardSudoku(){
		Random generator = new Random();
		int num = generator.nextInt(4)+28;
		int row,col;
		//The loop will continue until there are "num" filled tiles
		for(int i = 0; i<num; i++)
		{
			row = generator.nextInt(9);
			col = generator.nextInt(9);
			if(baseSudoku[row][col]==0)
				baseSudoku[row][col]=solvedSudoku[row][col];
			else
				i--;
		}
   	}
   	//Getters and Setters
	public static int[][] getSolvedSudoku(){
		return solvedSudoku;
	}
	public static void setSolvedSudoku(int[][] sudoku){
		solvedSudoku = sudoku;
	}
	public static int[][] getGenSudoku(){
		return genSudoku;
	}
	public static void setGenSudoku(int[][] sudoku){
		genSudoku = sudoku;
	}
	public static int[][] getBaseSudoku(){
		return baseSudoku;
	}
	public static void setBaseSudoku(int[][] sudoku){
		baseSudoku = sudoku;
	}
}