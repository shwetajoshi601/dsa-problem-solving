class PriorityQueueKthSmallestInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        // max heap
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b) -> {return b-a;});
        
        for(int i=0;i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                pq.add(matrix[i][j]);
                
                // when size exceeds k, remove element
                if(pq.size() > k)
                    pq.poll();
            }
        }
        
        // the first element is the kth smallest
        return pq.peek();
    }

    // O(k log k) / O(k)
    public int kthSmallestBetter(int[][] matrix, int k) {
        int m = matrix.length, n=matrix[0].length, ans = -1;
        
        // since the rows and columns are sorted, the problem is the same as finding the kth smallest in n sorted lists
        // we create a min heap and store the row and column along with the value
        Queue<int[]> minHeap = new PriorityQueue<int[]>(k, (a,b)-> {return a[0]-b[0];});
        
        // add the first element of each row to the queue
        for(int row=0; row<n; row++)
            minHeap.add(new int[]{matrix[row][0], row, 0});
        
        // pop k elements and add the next element of the current row into the heap
        // in the end, the top of the heap has the kth smallest element
        for(int i=0;i<k;i++) {
            int[] curr = minHeap.poll();
            ans = curr[0];
            int r = curr[1], col = curr[2];
            // if the next column is present, add it to the heap in form the same row
            if(col+1 < n)
                minHeap.add(new int[]{matrix[r][col+1], r, col+1});
        }
        
        return ans;
    }
}