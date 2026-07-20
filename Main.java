/*
Alonso Reyes Dominguez 
07/17/2026 
Purpose: Adds up two quadrants of a matrix using threads.  
Sources: 
		Got help from AI on calculating the quadrant indexs as I kept messing 
		it up. 
*/
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		//Open the file given on the command prompt
		Path path = Paths.get(args[0]);
		Scanner inFile = null;
		try {
			inFile =  new Scanner(path);
		} catch(IOException e) {
			System.out.println("IOException occurred. Check your file name and/or path.");
			System.exit(1);
		}
		
		int rows = inFile.nextInt();
		int columns = inFile.nextInt(); 

		int[][] A = readInMatrix(rows, columns, inFile); 
		int[][] B = readInMatrix(rows, columns, inFile);  
		int[][] C = new int[rows][columns]; 

		print2dArray(A);   
		
	}	

	public static int[][] readInMatrix(int rows, int columns, Scanner inFile)
	{
		int[][] toReturn = new int[rows][columns];
		
		for(int i = 0; i < rows; i++){ 
			for(int j = 0; j < columns; j++) {  
				toReturn[i][j] = inFile.nextInt();
			}
		} 

		return toReturn;
	}

	public static void print2dArray(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++){  
			for(int j = 0; j < matrix[i].length; j++){ 
				System.out.print(matrix[i][j] + " ");    
			}   
			System.out.println(); 
		}
	}

}