class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        int clockwise_dist = 0;
        int total_dist = 0;
        
        // if destination is < than start
        // interchange the indexes, the distances will be the same
        if(destination < start) {
            int temp = destination;
            destination = start;
            start = temp;
        }

        // find clockwise distance from start to end
        for(int i=start; i<destination; i++)
            clockwise_dist+=distance[i];
        
        // sum all the distances
        for(int i=0; i < distance.length; i++)
            total_dist+=distance[i];
        
        // difference between sum of all distances and the clockwise distance
        // will return the anti-clockwise distance
        // take the minimum value between the two
        return Math.min(clockwise_dist, (total_dist - clockwise_dist));
    }
}