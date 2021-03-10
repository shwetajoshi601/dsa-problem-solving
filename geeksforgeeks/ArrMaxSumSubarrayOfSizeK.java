// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        int i = 0, sum = 0, maxSum = Integer.MIN_VALUE;
        
        for(int j=0; j<N; j++) {
            sum += Arr.get(j);
            // find the length of the subarray at each step
            int currLen = j-i+1;
            if(currLen == K) {
                // subarray size = k
                // update max
                maxSum = Math.max(maxSum, sum);
                // move the window ahead
                // it means exclude the element at 
                sum -= Arr.get(i);
                i++;
                // j is incremented in the for loop
            }
        }
        
        return maxSum;
    }
}