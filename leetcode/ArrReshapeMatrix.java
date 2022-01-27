public class ArrReshapeMatrix {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int m = mat.length;
            int n = mat[0].length;
            
            // if the two matrices do not have equal number of elements
            // return the original matrix as reshaping is not possible
            if(r*c != m*n)
                return mat;
            
            int[][] reshaped = new int[r][c];
            int currRow = 0, currCol = 0;
            
            // iterate over the given matrix
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    reshaped[currRow][currCol] = mat[i][j];
                    
                    // check the column of the reshaped
                    // if all columns in the current row are full, start writing in the next row, c-1 denotes the last column
                    if(currCol >= c-1) {
                        currRow++;
                        currCol = 0;
                    } else
                    // write in the same row
                        currCol++;
                }
            }
            
            return reshaped;
        }
}
