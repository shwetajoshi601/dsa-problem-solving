class Day27FindRightInterval {
    // using Treemap and iteration over keys
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        
        // use tree map so that we get the next greater key(start point)
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        // create a map of (start, interval_index)
        for(int i=0; i<intervals.length; i++)
            map.put(intervals[i][0], i);
        
        for(int i=0; i< intervals.length; i++) {
            boolean found = false;
            // end of the current interval
            int end_val = intervals[i][1];
            // if there is an interval that starts with this intervals end point
            if(map.containsKey(end_val)) {
                // store the index of that interval from the map
                res[i] = map.get(end_val);
                found = true;
            } else {
                // check for intervals having start greater than the current's end
                // note that keys will be in sorted order giving us the smaller start point first
                for(Integer key:map.keySet()) {
                    if(key > end_val) {
                        res[i] = map.get(key);
                        found = true;
                        break;
                    }
                }
            }
            // not found
            if(!found) res[i] = -1;
        }

        return res;
    }

    // using TreeMap and use of Treemap.ceilingKey() method
    public int[] findRightIntervalFaster(int[][] intervals) {
        int[] res = new int[intervals.length];
        
        // use tree map so that we get the next greater key(start point)
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        // create a map of (start, interval_index)
        for(int i=0; i<intervals.length; i++)
            map.put(intervals[i][0], i);
        
        for(int i=0; i< intervals.length; i++) {
            // end of the current interval
            int end_val = intervals[i][1];
            // get the next greater of equal start point
            Integer next_start = map.ceilingKey(end_val);
            // if it exists get the index of the interval, else add -1
            res[i] = next_start == null ? -1 : map.get(next_start.intValue());
        }

        return res;
    }
}