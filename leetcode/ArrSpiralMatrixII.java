class ArrSpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int size = n*n;
        int num = 1;
        
        // pointers for traversals
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
        
        while(num <= size) {
            // top row
            for(int j=left; j<=right; j++) {
                matrix[top][j] = num;
                num++;
            }
            top++;
            
            // right column
            for(int j=top; j<=bottom; j++) {
                matrix[j][right] = num;
                num++;
            }
            right--;
            
            // bottom row
            for(int j=right; j>=left; j--) {
                matrix[bottom][j] = num;
                num++;
            }
            bottom--;
            
            // left column
            for(int j=bottom; j>= top; j--) {
                matrix[j][left] = num;
                num++;
            }
            left++;
        }
        
        return matrix;
    }
}