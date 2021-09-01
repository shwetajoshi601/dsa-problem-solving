class Pair {
    int num;
    int freq;
    
    Pair(int n, int f) {
        num = n;
        freq = f;
    }
}

class PriorityQueueReduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        if(arr.length == 1)
            return 1;
        
        int n = arr.length;
        
        // create a frequency map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        // add the unique elements into the priority queue based on their frequency counts - max heap
        Queue<Pair> pq = new PriorityQueue<Pair>((a,b)-> {return b.freq-a.freq;});
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));   
        }
        
        // initial set size will be 0 and the current length so far
        int setSize = 0, currLen = 0;
        // traverse through the elements until the length is reduced to half or less
        // since we take maximum freq element each time, we go on adding elements in the set size so that length reduces
        while(pq.size() > 0 && n-currLen > n/2) {
            setSize++;
            // remove the max element
            Pair p = pq.poll();
            // increment the current length with its freq
            currLen+=p.freq;
            
            // remaining length = total - current length removed
            // if it is reduced to half, stop
            // if(n-currLen <= n/2)
            //     break;
        }
        
        // return the size of the set
        return setSize;
    }

    // same approach, slightly better
    // no need to add both the element and the frequency, we only need the frequency in the priority queue
    public int minSetSizeBetter(int[] arr) {
        if(arr.length == 1)
            return 1;
        
        int n = arr.length;
        
        // create a frequency map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        // add the unique elements into the priority queue based on their frequency counts - max heap
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b)-> {return b-a;});
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            pq.add(e.getValue());   
        }
        
        // initial set size will be 0 and the current length so far
        int setSize = 0, currLen = 0;
        // traverse through the elements until the length is reduced to half or less
        // since we take maximum freq element each time, we go on adding elements in the set size so that length reduces
        while(pq.size() > 0 && n-currLen > n/2) {
            setSize++;
            // remove the max element
            // increment the current length with its freq
            currLen+=pq.poll();
            
            // remaining length = total - current length removed
            // if it is reduced to half, stop
            // if(n-currLen <= n/2)
            //     break;
        }
        
        // return the size of the set
        return setSize;
    }
}