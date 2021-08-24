import java.util.*;

public class HeapFindKthSmallestInMinHeap {
    
    static int findKthSmallest(int[] minHeap, int k) {
        if(k > minHeap.length || minHeap.length == 1)
            return -1;
        
        // the idea is to perform deletion k times
        // the kth deleted element is the kth smallest in a min heap
        int kthMin = minHeap[0];
        int n = minHeap.length;
        
        for(int i = 0; i < k; i++)
            // reduce n to avoid deleted elements
            kthMin = deleteMin(minHeap, n--);
            
        return kthMin;
    }
    
    static int deleteMin(int[] minHeap, int n) {
        //swap the last element with the first
        // first element is the min in a min heap
        int min = minHeap[0];
        swap(minHeap, 0, n-1);
        
        // reduce n so that last element in not touched
        // after swapping min element is at the last
        // we exclude it by reducing the size
        // heapify the element at first position as it may not satisfy heap property
        heapify(minHeap, 0, n-1);
        return min;
    }
    
    // min heapify function
    static void heapify(int[] minHeap, int i, int n) {
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i + 2;
        
        if(left < n && minHeap[left] < minHeap[i])
            smallest = left;
            
        if(right < n && minHeap[right] < minHeap[smallest])
            smallest = right;
            
        if(smallest != i) {
            // swap
            swap(minHeap, smallest, i);
            heapify(minHeap, smallest, n);
        }
    }
    
    // function to swap
    static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public static void main(String args[]) {
        int[] minHeap = {2,3,15,5,4,45,80,6,150,77,120};
        int k = 6;
        System.out.println(findKthSmallest(minHeap, k));
    }
}
