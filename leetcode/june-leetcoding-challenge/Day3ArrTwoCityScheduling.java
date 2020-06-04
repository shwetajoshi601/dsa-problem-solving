import java.util.*;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        // comparator to sort the array by the difference in cost of two cities
        Comparator<int[]> comp=new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                // [[10, 20], [30, 50]] -> [-10, -20] -> sorted as: [[30, 50], [10, 20]]
                return ((a[0]-a[1]) - (b[0] - b[1]));
            }
        };
        
        // sort the costs array
        Arrays.sort(costs, comp);
        
        int minCost=0;
        
        // greedily pick the first city for N people
        // send the next N people to the second city
        // this approach works since we are given that there will always be 2N people and each city must have exactly N people.
        // Here, 2N=4, N=2
        for(int i=0; i<costs.length; i++) {
            // if the current person is below Nth person
            if(i < costs.length/2)
                // send to city A
                minCost+=costs[i][0];
            else
                // send to city B
                minCost+=costs[i][1];
        }
        
        return minCost;
    }
}