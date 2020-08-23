class ArrMergeOverlappingSubintervals {
    public int[][] merge(int[][] intervals) {
        // empty input
        if(intervals == null || intervals.length == 0)
            return new int[0][];
        
        // result
        ArrayList<int[]> res = new ArrayList<int[]>();
        
        // sort the intervals based on the start
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        // set the current interval
        int[] curr = intervals[0];
        
        // iterate over each interval
        for(int[] interval: intervals) {
            // check if it overlaps with the curr interval
            // its start lies within the range of the curr interval
            if(interval[0] <= curr[1]) {
                // overlapping interval
                // merge
                curr[0] = Math.min(curr[0], interval[0]);
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                // non-overlapping interval
                // add the curr interval to the result
                res.add(curr);
                // update the curr interval
                curr = interval;
            }
        }
        // when the loop ends, the last interval is stored in curr
        // add this interval to the result
        res.add(curr);
        
        // convert array list to array
        return res.toArray(new int[0][]);
    }
}