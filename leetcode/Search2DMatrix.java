class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length==0) return false;
        
        int m =matrix.length;
        int n=matrix[0].length;
        int start = 0, end = n-1;
        
        while(start < m && end >= 0) {
            if(matrix[start][end] == target)
                return true;
            else if(target < matrix[start][end])
                end--;
            else
                start++;
        }
        return false;
    }
}