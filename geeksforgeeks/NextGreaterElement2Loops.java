import java.util.*;
import java.lang.*;
import java.io.*;
class NextGreaterElement2Loops
 {
    public static void getNextLargerElement(int[] arr) {
        //System.out.println();
        for(int i=0; i<arr.length; i++) {
            boolean found = false;
            for(int j=i+1; j<arr.length;j++) {
                if(arr[j] > arr[i]) {
                    found = true;
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
            if(!found) System.out.print(-1 + " ");
        }
    }
     
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0) {
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int j=0; j<n; j++) {
	            arr[j] = sc.nextInt();
	        }
	        getNextLargerElement(arr);
	        System.out.println();
	    }
	 }
}