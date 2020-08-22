class Day21SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        // result array
        int[] res = new int[A.length];
        
        // put even elements from the beginning
        int even_index = 0;
        // put odd elements from the end
        int odd_index = A.length - 1;
        
        // iterate over the input array
        for(int i=0; i<A.length; i++) {
            // even
            if(A[i] % 2 == 0)
                // place at the next position from the beginning
                res[even_index++] = A[i];
            else
            // odd
                // place at the next position from the end
                res[odd_index--] = A[i];
        }
        
        return res;
    }

    public int[] sortArrayByParityInPlace(int[] A) {
        int i=0, j=A.length-1;
        
        while(i < j) {
            // A[i] is odd and A[j] is even
            if(A[i] % 2 > A[j] % 2) {
                // swap the two
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            
            // A[i] is even -> correct position
            if(A[i] % 2 == 0) i++;
            // A[j] is odd -> correct position
            if(A[j] % 2 == 1) j--; 
        }
        
        return A;
    }
}