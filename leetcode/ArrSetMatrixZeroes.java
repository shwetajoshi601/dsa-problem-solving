class ArrSetMatrixZeroes {
    // using O(m+n) extra space
    public void setZeroesUsingExtraSpace(int[][] matrix) {
        int m=matrix.length, n = matrix[0].length;
        
        // maintain two sets to store the row numbers and column numbers needed to be zeroed
        Set<Integer> row_set = new HashSet<Integer>();
        Set<Integer> col_set = new HashSet<Integer>();
        
        // iterate over the matrix
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // check if the value is 0
                if(matrix[i][j] == 0) {
                    // value 0
                    // store the row number and column number
                    row_set.add(i);
                    col_set.add(j);
                }
            }
        }
        
        // set values in stored row numbers to 0
        // for each row number
        for(int row_no: row_set) {
            // set each value in the row to 0
            for(int i=0; i<n; i++) {
                matrix[row_no][i]=0;
            }
        }
        
        // set values in stored col numbers to 0
        // for each column number
        for(int col_no: col_set) {
            // set each value in the column to 0
            for(int i=0; i<m; i++) {
                matrix[i][col_no] = 0;
            }
        }
    }

     // using O(1) extra space
     public void setZeroes(int[][] matrix) {
        int m=matrix.length, n = matrix[0].length;
        // use the first row and first col to indicate which rows and cols to make 0
        
        // since they will be overwritten, check if they contasin a zero, so that they can be made zero at the end
        boolean firstRowZero = false, firstColZero = false;
        
        // check if the first row contains a zero
        for(int j=0; j<n; j++) {
            if(matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // check if the first col contains a zero
        for(int i=0; i<m; i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // iterate over the matrix except the first row and col
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 0) {
                    // set the value in ith row and first col to 0
                    matrix[i][0] = 0;
                     // set the value in first row and jth col to 0
                    matrix[0][j] = 0;
                }
            }
        }
        
        // check which rows and cols need to be made zero using the first row and col
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                // if value in first row or col is zero
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    // make the corresponding value 0
                    matrix[i][j]=0;
            }
        }
        
        // check if first row had a zero
        if(firstRowZero) {
            // make all values in first row 0
            for(int j=0; j<n; j++) matrix[0][j] = 0;
        }
        
        // check if first col had a zero
        if(firstColZero) {
            // make all values in first col 0
            for(int i=0; i<m; i++) matrix[i][0] = 0;
        }
    }
}