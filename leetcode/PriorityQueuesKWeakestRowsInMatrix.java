class Pair {
    int index;
    int n_soldiers;
    
    Pair(int i, int soldiers) {
        index = i;
        n_soldiers = soldiers;
    }
}

class PriorityQueuesKWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // create a min heap based on soldier count and index
        Queue<Pair> pq = new PriorityQueue<Pair>(m, (p1, p2) -> {
            // if soldier count is equal, sort by index
            if(p1.n_soldiers == p2.n_soldiers)
                return p1.index - p2.index;
            
            return p1.n_soldiers - p2.n_soldiers;
        });
        
        // iterate through the matrix
        // get the soldier count for each row
        for(int i = 0; i<m; i++) {
            int soldierCount = 0;
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1)
                    soldierCount++;
            }
            
            // add the row index and soldier count into the heap
            pq.add(new Pair(i, soldierCount));
        }
        
        // pick the first k values in the heap
        int[] kWeakest = new int[k];
        
        for(int p=0;p<k;p++) {
            kWeakest[p] = (pq.poll()).index;
        }
        
        return kWeakest;
    }
}