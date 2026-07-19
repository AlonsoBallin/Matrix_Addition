public class ThreadOperation extends Thread {
    //Varaiables 
    private int[][] A; 
    private int[][]B; 
    private int[][] C; 
    private String thread; 

    public ThreadOperation(int[][] A, int[][] B, int[][] C, String thread) { 
        this.A = A; 
        this.B = B; 
        this.C = C; 
        this.thread = thread; 
    } 

    @Override 
    public void run() { 
        int rows = A.length; 
        int columns = A[0].length; 

        int[] index = getQuadrantIndex(rows, columns, thread); 

        int startRow = index[0]; 
        int endRow = index[1]; 
        int startColumn = index[2]; 
        int endColumn = index[3]; 

        for(int i = startRow; i < endRow; i++) { 
            for(int j = startColumn; j < endColumn; j++) { 
                C[i][j] = A[i][j] + B[i][j]; 
            } 
        } 
    } 


}
