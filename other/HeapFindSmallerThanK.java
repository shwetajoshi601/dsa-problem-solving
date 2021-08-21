import java.util.*;

public class HeapFindSmallerThanK {
    
    static void findSmaller(int[] minHeap, int key, int index) {
        // do a pre order traversal of the heap
        if(index > minHeap.length)
            return;
        
        // in a min heap, the child values are greater than the node
        // hence no need to traverse its children, elements < k wont be found
        if(minHeap[index] >= key)
            return;
        
        // current value less than key
        System.out.print(minHeap[index] + " ");
        
        int left = 2*index+1;
        int right = 2*index+2;
        
        // recursively find in left and right
        findSmaller(minHeap, key, left);
        findSmaller(minHeap, key, right);
    }
    
    public static void main(String args[]) {
        int[] minHeap = {2,3,15,5,4,45,80,6,150,77,120};
        int key = 15;
        findSmaller(minHeap, key, 0);
    }
}
