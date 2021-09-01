class PriorityQueueKClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][];
        
        // create a max heap according to the distance from the origin
        Queue<int[]> pq = new PriorityQueue<int[]>(k, (a, b) -> {
            // distance from the origin is nothing sqrt(x^2 + y^2)
            double dist1 = Math.sqrt((b[0]*b[0]) + (b[1]*b[1]));
            double dist2 = Math.sqrt((a[0]*a[0]) + (a[1]*a[1]));
            
            // sort in descending order
            if(dist1 < dist2)
                return -1;
            else if(dist1 > dist2)
                return 1;
            return 0;
        });
        
        for(int i = 0; i<points.length; i++) {
            // add the point to the heap
            pq.add(points[i]);
            
            // maintain only k elements in the heap
            // when we poll we remove the element with the max distance
            // hence we keep only the points that have less distance (closest)
            if(pq.size() > k)
                pq.poll();
        }
        
        // add the points left from the heap to the result array
        int index = 0;
        while(!pq.isEmpty())
            result[index++] = pq.poll();
        
        return result;
    }
}