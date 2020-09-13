class ArrGridUniquePaths {
    
    // gives TLE - exponential complexity - all posible paths are found
    // exponential space complexity
    int countPaths(int i, int j, int m, int n) {
        // reached Finish mark
        if(i==m-1 && j==n-1) return 1;
        // index out of bound, no path exists
        if(i>=m || j>=n) return 0;
        // total number of paths is the sum of paths found by moving right and moving down
        return countPaths(i+1, j, m, n) + countPaths(i, j+1, m, n);
    }
    
    public int uniquePaths(int m, int n) {
        // recursively find paths from a given i, j
        return countPaths(0, 0, m, n);
    }
}