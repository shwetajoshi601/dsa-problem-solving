import java.util.*;

class RecursionKthGrammar {
    public int kthGrammar(int n, int k) {
        if(n == 1 && k == 1)
            return 0;
        
        // length of the numbers in the grammar/2
        // for each n, number of elements are given by 2^(n-1)
        int mid = (int)Math.pow(2, n-1)/2;
        
        // if you carefully observe, the first mid number of elements of n and n-1 are exactly the same
        // so, we can recursively call for n-1 without changing the value of k
        if(k <= mid) 
            return kthGrammar(n-1, k);
        else
        // if k falls beyond the mid index,
        // the next half of the row n, is the same as the complement of n-1
        // n= 2 -> 1001, last half of n=3 -> 0110
        // so we map the index accordingly and complement the value
            return complement(kthGrammar(n-1, k-mid));
    }
    
    int complement(int bit) {
        switch(bit) {
            case 0: return 1;
            case 1: return 0;
        }
        
        return -1;
    }
}
