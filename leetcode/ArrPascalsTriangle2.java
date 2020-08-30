class ArrPascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        // for 3rd index, there would be at the most 4 elements
        Integer[] res = new Integer[rowIndex+1];
        
        // to maintain the value at previous position of previous row
        int prev = 0;
        
        for(int i=0; i<=rowIndex+1; i++) {
            for(int j=0; j<i; j++) {
                if(j == 0 || j==i-1) {
                    // first and last element of the row
                    res[j]=1;
                    prev = 1;
                } else {
                    // store the value of previous row
                    int temp = res[j];
                    // add and update the value for current row
                    res[j] = prev + res[j];
                    // maintain the previous state for next iteration
                    prev = temp;
                }
            }
        }
        
        return Arrays.asList(res);
    }
}