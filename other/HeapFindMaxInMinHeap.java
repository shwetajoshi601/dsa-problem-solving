import java.util.*;

public class HeapFindMaxInMinHeap {
    
    static int getMax(int[] minHeap, int n) {
        int max = Integer.MIN_VALUE;
        
        if(n == 0)
            return max;
        
        // a heap is a complete binary tree. According to heap property,
        // child nodes are always > root in a min heap. 
        // Hence, all the possible max values will always be in the last level
        // Since its complete BT, a heap can have n/2 nodes in the leaves.
        // hence we only need to check the values of n/2th node onwards and find the max
        for(int i=n/2; i<n; i++) {
            max = Math.max(minHeap[i], max);
        }
        
        return max;
    }
    
    public static void main(String args[]) {
        int[] minHeap = {1,2,3,5,6,4};
        System.out.println(getMax(minHeap, minHeap.length));
    }
}
