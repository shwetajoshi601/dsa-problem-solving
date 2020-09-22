// { Driver Code Starts
    import java.util.*;

    class MaxLenZeroSumSub
    {
    
        // Returns length of the maximum length subarray with 0 sum
    
        // Drive method
        public static void main(String arg[])
        {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T > 0)
            {
                int n = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++)
                    arr[i] = sc.nextInt();
    
                GfG g = new GfG();
                System.out.println(g.maxLen(arr, n));
                T--;
            }
        }
    }// } Driver Code Ends
    
    
    
    class ArrLargestSubarrayWithZeroSum
    {
        int maxLen(int arr[], int n)
        {
            // map of sum->index
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            
            int sum=0, maxLen=0;
            
            for(int i=0; i<arr.length; i++) {
                // calculate sum
                sum+=arr[i];
                
                // upto index i the sum is 0, which means length is i+1
                if(sum == 0)
                    maxLen = i+1;
                
                // if the current sum is present in the map
                if(map.containsKey(sum))
                    // if the sum is already present, means there was already a sub array with that sum
                    // so update the max length
                    // current index - prev index at which the sum was encountered
                    maxLen = Math.max(maxLen, i-map.get(sum));
                else
                // sum not present, put store it with index
                    map.put(sum, i);
            }
            
            return maxLen;
        }
    }