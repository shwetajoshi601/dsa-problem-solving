// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

class ArrMergeTwoSortedArraysWithoutExtraSpace
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int arr1[] = new int[n];
		    int arr2[] = new int[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    new MergeSort().merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class MergeSort
{
    // O(mn) time, O(1) space
    // TODO: gives the correct output, but need to improve the time complexity for it to be accepted
    public static void merge(int arr1[], int arr2[], int n, int m) 
    {
        // check if there is a larger element in arr1
        for(int i=0; i<n; i++) {
            if(arr1[i] > arr2[0]) {
                // found an element greater than the first element of arr2
                // since both are sorted, any element greater than first elem of arr2
                // will be greater than all its elems
                
                // swap the two elements
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                
                // now move the swapped element in arr2 to its correct pos to maintain the sorted order
                int first = arr2[0];
                int k;
                for(k=1; k<m && arr2[k] < first; k++)
                    arr2[k-1] = arr2[k];
                    
                arr2[k-1] = first;
            }
        }
    }
}
