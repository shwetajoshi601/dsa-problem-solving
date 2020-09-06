class ArrSearch2DMatrix {
    // O(mxn) solution
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++) {
            // for each row
            // check if the target lies in the range of that row - first_elem <= target <= last_elem
            // This works since each row's first_elem is > prev row's last_elem
            if(matrix[i].length > 0 && matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target) {
                // if it is within the range, traverse the row
                int j=0;
                while(j < matrix[i].length) {
                    // found the target
                    if(target == matrix[i][j])
                        return true;
                    // if at any point the value becomes > target
                    // target is not present. Note that the matrix is sorted row wise
                    else if(matrix[i][j] > target)
                        return false;
                    
                    j++;
                }
            }
        }
        
        // target not found after traversing the whole matrix
        return false;
    }

    // Better solution O(m+n) - Using the info the matrix is row wise and column wise sorted
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        
        int i = 0, j = matrix[0].length - 1;
        // given that the matrix is row wise and column wise sorted
        // start from the last element of the first row
        // elements below this element are greater, and elements to the left are smaller
        while(i < matrix.length && j >= 0) {
            // target found
            if(matrix[i][j] == target) return true;
            // if element is greater than target, move left
            else if(matrix[i][j] > target) j--;
            // element smaller than target, move down
            else i++;
        }
        return false;
    }

    // Optimal solution - O(log(m+n)) - using binary search
    // Note: this will not work for gfg variant since it does specify that: 
    // each row's first element is greater than prev row's last element
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // it given that each row's first element is greater than prev row's last element
        // this means, if we join all the rows into a single array
        // we get a sorted array. Binary search can be applied on this array
        // we do not use additional space, we map the matrix indices to perform BS.
        int low = 0;
        // last index, if it would have been a single array
        int high = m*n-1;
        
        while(low <= high) {
            int mid = low+(high-low)/2;
            
            // mid/n gives the row, mid%n gives the col
            if(matrix[mid/n][mid%n] == target)
                return true;
            else if(matrix[mid/n][mid%n] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        
        return false;
    }
}