// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class ArrFloorInSortedArray
    {
        public static void main (String[] args)throws IOException {
    
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            
            while(t-- > 0)
            {
               String a[] = read.readLine().trim().split("\\s+");
               int n = Integer.parseInt(a[0]);
               long x = Long.parseLong(a[(int)1]);
               String st[] = read.readLine().trim().split("\\s+");
            
               long arr[] = new long[n];
               for(int i = 0; i < n; i++)
               {
                   arr[i] = Long.parseLong(st[i]);
               }
               
               System.out.println(new Solution().findFloor(arr, n, x));
              
            }
        }
        
    }// } Driver Code Ends
    
    
    class Solution{
        
        // Function to find floor of x
        // arr: input array
        // n is the size of array
        static int findFloor(long arr[], int n, long x)
        {
            int low = 0, high = n-1;
            int floor = -1;
            
            while(low <= high) {
                int mid = low + (high-low)/2;
                
                if(arr[mid] == x)
                    return mid;
                
                if(arr[mid] < x) {
                    // any element less than the target is a possible floor value
                    // we do not need to check if arr[mid] is greater than the current floor
                    // this because the array is sorted, so if we move right, it is always going to be greater than previoud floor value
                    floor = mid;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            
            return floor;
        }
        
    }
    