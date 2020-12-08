// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class ArrCommonElements {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking total count-1 of elements 
		    int n=sc.nextInt();
		    
		    //Declaring and Initializing an ArrayList-1
		    ArrayList<Integer>v1=new ArrayList<>();
		    
		    //adding elements to the ArrayList-1
		    for(int i=0;i<n;i++)
		    {
		        v1.add(sc.nextInt());
		    }
		    
		    //taking total count-2 of elements 
		    int m=sc.nextInt();
		    
		    //Declaring and Initializing an ArrayList-2
		    ArrayList<Integer>v2=new ArrayList<>();
		    
		    //adding elements to the ArrayList-2
		    for(int i=0;i<m;i++)
		    {
		        v2.add(sc.nextInt());
		    }
		    
		    //calling the method common_element
		    //and passing ArrayList 1, 2 as arguments
		    //and storing the results in a new ArrayList
		    ArrayList<Integer>ans=common_element(v1, v2);
		    
		    //printing the elements of the new ArrayList
		    for(int i:ans)
		    System.out.print(i+" ");
		    
		    System.out.println();
		}
	}
	

 // } Driver Code Ends


//User function Template for Java

public static ArrayList<Integer> common_element(ArrayList<Integer>v1, ArrayList<Integer>v2)
{
    ArrayList<Integer> res = new ArrayList<Integer>();
    Map<Integer, Integer> map1 = new TreeMap<Integer, Integer>();
    Map<Integer, Integer> map2 = new TreeMap<Integer, Integer>();
    
    for(Integer i: v1)
        map1.put(i, map1.getOrDefault(i, 0)+1);
        
    for(Integer j: v2)
        map2.put(j, map2.getOrDefault(j, 0)+1);
    
    for(Map.Entry<Integer, Integer> e: map1.entrySet()) {
        if(map2.containsKey(e.getKey())) {
            // common element
            int minFreq = Math.min(e.getValue(), map2.get(e.getKey()));
            for(int i=0; i<minFreq; i++)
                res.add(e.getKey());
        }
    }
    
    return res;
}


// { Driver Code Starts.

}  // } Driver Code Ends