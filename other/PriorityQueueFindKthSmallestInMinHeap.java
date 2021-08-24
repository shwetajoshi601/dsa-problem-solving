import java.util.*;

class Pair {
    int value;
    int index;
    
    Pair(int val, int i) {
        value = val;
        index = i;
    }
}

public class PriorityQueueFindKthSmallestInMinHeap {
    
    static int findKthSmallest(int[] minHeap, int k) {
        if(k > minHeap.length || minHeap.length == 1)
            return -1;
        
        int n = minHeap.length;
        
        // create a priority PriorityQueue
        Queue<Pair> pq = new PriorityQueue<Pair>(k, (a,b) -> {
            if(a.value < b.value)
                return -1;
            else if(a.value > b.value)
                return 1;
            return 0;
        });
        
        // add the root in the pq (value, index in heap)
        pq.add(new Pair(minHeap[0], 0));
        
        // now for k-1 elements, pop them from the Queue
        // add its left and right child for further exploring
        // the comparator of the queue ensures that the min element is at the front always
        // hence popping k-1 times would leave the kth smallest at the front
        for(int i = 0; i < k-1; i++) {
            Pair pair = pq.poll();
            int left = 2*pair.index + 1;
            int right = 2*pair.index + 2;
            
            if(left < n)
                pq.add(new Pair(minHeap[left], left));
                
            if(right < n)
                pq.add(new Pair(minHeap[right], right));
        }
            
        return pq.peek().value;
    }
    
    public static void main(String args[]) {
        int[] minHeap = {2,3,15,5,4,45,80,6,150,77,120};
        int k = 6;
        System.out.println(findKthSmallest(minHeap, k));
    }
}
