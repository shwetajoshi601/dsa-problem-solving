import java.util.*;
import java.io.*;
import java.lang.*;

class ArrMaxOfAllSubarraysOfSizeK
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends



class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> maxList = new ArrayList<Integer>();
        for(int i=0; i<=n-k; i++) {
            int max = arr[i];
            for(int j=i; j < (i+k);  j++)
                max = Math.max(max, arr[j]);
                
            maxList.add(max);
        }
        
        return maxList;
    }

    //Function to find maximum of each subarray of size k.
    // TODO: not yet working, WIP
    static ArrayList <Integer> max_of_subarrays_better(int arr[], int n, int k)
    {
        ArrayList<Integer> maxList = new ArrayList<Integer>();
        // we use a deque to keep track of the maximum elements in the current window
        Deque<Integer> queue = new LinkedList<Integer>();
        
        int i = 0, j =0;
        
        while(j < n) {
            // window size
            if(j-i+1 < k) {
                // add elements
                // add to the queue only is they are maximum
                // any elements already present in the queue and less
                // are removed, smaller elements aren't useful
                while(!queue.isEmpty() && queue.peekLast() < arr[j])
                    queue.removeLast();
                    
                // add the current element to the queue
                queue.addLast(arr[j]);
                j++;
            } else if(j-i+1 == k) {
                // find the maximum of the window
                // we only store maximal elements in the queue
                // hence the max will be at the front
                int max = Integer.MIN_VALUE;
                if(!queue.isEmpty()) {
                    max = queue.peekFirst();
                    maxList.add(max);   
                }
                
                // now slide the window, remove the leftmost element
                // if the element being excluded from the window
                // is the max of the previous window
                // we need to remove it from the queue -> from the front
                if(max == arr[i])
                    queue.removeFirst();
                    
                i++;
                j++;
            }
        }
        
        return maxList;
    }
}