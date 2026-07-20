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

		ThreadOperation upperLeft = new ThreadOperation(A, B, C, "Upper left"); 
		ThreadOperation upperRight = new ThreadOperation(A, B, C, "Upper right"); 
		ThreadOperation lowerLeft = new ThreadOperation(A, B, C, "Lower left");
		ThreadOperation lowerRight = new ThreadOperation(A, B, C, "Lower right");

		upperLeft.start();
		upperRight.start();
		lowerLeft.start();
		lowerRight.start(); 

		System.out.println("Matrix A:"); 
		print2dArray(A); 

		System.out.println("Matrix B:"); 
		print2dArray(B); 

		System.out.println("Matrix C:"); 
		print2dArray(C); 

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
				System.out.printf("%5d", matrix[i][j]);    
			}   
			System.out.println(); 
		}
	}

}