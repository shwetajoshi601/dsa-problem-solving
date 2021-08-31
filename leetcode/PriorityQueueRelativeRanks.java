class Pair {
    int index;
    int score;
    
    Pair(int i, int s) {
        index = i;
        score = s;
    }
}

class PriorityQueueRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n =  score.length;
        // result
        String[] ranks = new String[n];
        
        if(n == 0)
            return ranks;
        
        // create a max heap of scores and also store the index in the score array
        Queue<Pair> pq = new PriorityQueue<Pair>(n, (a,b)-> {
            return b.score-a.score;
        });
        
        // add all the scores to the heap
        int i = 0;
        for(;i<n;i++)
            pq.add(new Pair(i, score[i]));
        
        // pop the score and add its corresponding rank to the result
        for(i=1; i<=n; i++) {
            Pair curr = pq.poll();
            // store according to original index
            ranks[curr.index] = getMedal(i);
        }
        
        return ranks;
    }
    
    // function to get the medal/rank according to the number
    String getMedal(int rank) {
        switch(rank) {
            case 1: return "Gold Medal";
            case 2: return "Silver Medal";
            case 3: return "Bronze Medal";
            default: return String.valueOf(rank);
        }
    }
}