class ArrSpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(matrix == null || matrix.length == 0) return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        // we need to stop when all the elements have been traversed
        // get the number of elements in the matrix
        int size = m*n;
        
        // define the boundaries
        // first row
        int top = 0;
        // last column
        int right = matrix[0].length-1;
        // last row
        int bottom = matrix.length-1;
        // first column
        int left = 0;
        
        int i;
        while(res.size() < size) {
            // traverse the top row
            for(i=left; i<=right && res.size() < size; i++)
                res.add(matrix[top][i]);
            
            // first row -> 1,2,3 -> 3 is already added in the first loop
            // hence move top 1 step down
            top++;
            
            // traverse the rightmost column
            for(i=top; i<=bottom && res.size() < size; i++)
                res.add(matrix[i][right]);
            
            // move right one step inward
            right--;
            
            // bottom row
            for(i=right; i>=left && res.size() < size; i--)
                res.add(matrix[bottom][i]);
            
            bottom--;
            
            // leftmost column
            for(i=bottom; i>=top && res.size() < size; i--)
                res.add(matrix[i][left]);
            left++;
        }
        
        return res;
    }
}