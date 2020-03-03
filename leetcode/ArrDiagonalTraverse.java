class ArrDiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0) return new int[0];
        
        int m=matrix.length;
        int n=matrix[0].length;
        // total no. of elements
        int[] res = new int[m*n];
        
        int row=0, col=0;
        
        for(int i=0; i<res.length; i++) {
            res[i] = matrix[row][col];
            
            // for even diagonals - move up
            // for odd diagonals - move down
            if((row+col) % 2 == 0) {
                // even diagonal
                
                // edge cases - first row/last col
                if(col==n-1) row++;              // switch to next row
                else if(row == 0) col++;         // switch to next column
                else {                           // move up
                    row--;
                    col++;
                }
            } else {
                // odd diagonal - move down
                
                // edge cases - first col, last row
                if(row==m-1) col++;         // switch to next column
                else if(col==0) row++;      // switch to next row
                else {                      // move down
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}