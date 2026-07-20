public class ThreadOperation extends Thread {
    //Varaiables 
    private int[][] A; 
    private int[][]B; 
    private int[][] C; 
    private String quadrant; 

    //Constructor 
    public ThreadOperation(int[][] A, int[][] B, int[][] C, String quadrant) { 
        this.A = A; 
        this.B = B; 
        this.C = C; 
        this.quadrant = quadrant; 
    } 

    //Run Method for rows and columns 
    @Override 
    public void run() { 
        int rows = A.length; 
        int columns = A[0].length; 

        int[] index = getQuadrantIndex(rows, columns, quadrant); 

        int startRow = index[0]; 
        int endRow = index[1]; 
        int startColumn = index[2]; 
        int endColumn = index[3]; 

        for(int i = startRow; i <= endRow; i++) { 
            for(int j = startColumn; j <= endColumn; j++) { 
                C[i][j] = A[i][j] + B[i][j]; 
            } 
        } 
    } 

    //Getting the quadrant 
    public int[] getQuadrantIndex(int rows, int columns, String thread) { 
        int midRow = rows / 2; 
        int midColumn = columns / 2; 

        int[] index = new int[4]; 

        if(quadrant.equals("Upper left")){ 
            index[0] = 0; 
            index[1] = midRow; 
            index[2] = 0; 
            index[3] = midColumn - 1; 
        } 
        else if(quadrant.equals("Upper right")){ 
            index[0] = 0; 
            index[1] = midRow - 1; 
            index[2] = midColumn; 
            index[3] = columns - 1; 
        } 
        else if(quadrant.equals("Lower left")){ 
            index[0] = midRow; 
            index[1] = rows - 1; 
            index[2] = 0; 
            index[3] = midColumn - 1; 
        } 
        else if(quadrant.equals("Lower right")){ 
            index[0] = midRow; 
            index[1] = rows - 1; 
            index[2] = midColumn; 
            index[3] = columns - 1; 
        } 
        return index; 
    }


}
