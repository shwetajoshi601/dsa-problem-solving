import java.util.*;

public class HeapArbitraryDelete {
    static int size = 6;
    
    static void heapify(int[] arr, int n, int i) {
        if(n == 0 || n == 1)
            return;
            
        int left = 2*i + 1;
        int right = 2*i + 2;
        int smallest = i;
        
        if(left < n && arr[left] <= arr[smallest])
            smallest = left;
            
        if(right < n && arr[right] <= arr[smallest])
            smallest = right;
            
        if(smallest != i) {
            // swap with the smaller child
            swap(arr, i, smallest);
            // heapify the element at smallest
            heapify(arr, n, smallest);
        }
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void delete(int[] minHeap, int n, int key) {
        for(int i=0; i<n; i++) {
            if(minHeap[i] == key) {
                // found the element to delete
                // replace the element to delete with the last element
                // remove an element from the end is easier in HeapArbitraryDelete
                swap(minHeap, i, n-1);
                
                // now reduce the size of the heap;
                size--;
                n=n-1;
                
                // the last element place at i may not satisfy the heap property
                // hence, heapify this element
                heapify(minHeap, n, i);
                return;
            }
        }
        
        System.out.println("Element not found");
    }
    
    public static void main(String args[]) {
        int[] minHeap = {1,2,3,5,6,4};
        delete(minHeap, minHeap.length, 2);
        System.out.println("Heap after deletion: ");
        for(int i = 0; i<size; i++)
            System.out.print(minHeap[i] + " ");
    }
}
