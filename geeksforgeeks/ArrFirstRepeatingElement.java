// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class ArrFirstRepeatingElement {
	public static void main (String[] args) {
	    
	    //Taking input using class Scanner
		Scanner sc=new Scanner(System.in);
		
		//Taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total count of elements
		    int n=sc.nextInt();
		    
		    //creating a new array of size n
		    int arr[]=new int[n];
		    
		    //inserting elements to the array
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }
		    
		    //calling firstRepeated method 
		    //and printing the result
		    System.out.println(firstRepeated(arr,n));
		}
		
	}
	

 // } Driver Code Ends


//User function Template for Java


public static int firstRepeated(int []arr, int n) 
{
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for(int i=0; i<arr.length; i++) {
        map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
    }
    
    for(int i=0; i<arr.length; i++) {
        if(map.containsKey(arr[i]) && map.get(arr[i]) > 1)
            return i+1;
    }
    
    return -1;
}


// { Driver Code Starts.

}  // } Driver Code Ends