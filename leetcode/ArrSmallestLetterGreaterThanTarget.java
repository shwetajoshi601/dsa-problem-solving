class ArrSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        // the question says characters wrap around
        // we need to wrap around only when there is no character greater than the target in the array
        // in this case, the nextGreatest is nothing but the smallest element in the array
        // since the arr is sorted, the first element is the smallest
       char nextGreatest = letters[0];
        
        // search using binary search
        int low = 0, high = letters.length-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(letters[mid] <= target) {
                low = mid+1;
            } else {
                // found a potential greatest element
                nextGreatest = letters[mid];
                high = mid-1;
            }
        }
    
        return nextGreatest;
    }
}