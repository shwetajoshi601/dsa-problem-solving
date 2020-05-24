import java.util.*;

public class ArrIntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0, j=0;
        List<int[]> res=new ArrayList<int[]>();
        
        // i-> A pointer, j->b pointer
        while(i<A.length && j<B.length) {
            // if an overlap exists
            // overlap exists when the end of B > start of A and start B < end of A
            if(B[j][1] >= A[i][0] && B[j][0] <= A[i][1]) {
                int[] temp=new int[2];
                // start of the intersection is the max of the two start points
                temp[0]=Math.max(A[i][0], B[j][0]);
                // end of the intersection is the min of the two end points
                // e.g.: A[0, 2], B[1, 5] -> [1, 2]
                temp[1]=Math.min(A[i][1], B[j][1]);
                res.add(temp);
            }
            
            // both cannot the incremented at the same time since interval lengths are different
            // hence we increment the pointer for the list with a smaller interval.
            // A ends at 10 and B ends at 5. Then we increment B pointer.
            if(A[i][1] > B[j][1])
                j++;
            else
                i++;
        }

        // form the resulting array
       int[][] result=new int[res.size()][2];
       int k=0;
        for(int[] a: res) {
           result[k++] = a;
       }
        
        return result;
    }
}