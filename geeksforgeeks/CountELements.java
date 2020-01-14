{
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.HashMap;
class CountELements
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			//int k = sc.nextInt();
			
			GfG g = new GfG();
			g.countDistinct(a,k,n);			
			System.out.println();
		
		t--;
		}
	}
}
}
/*This is a function problem.You only need to complete the function given below*/
/*You are required to complete below method */
class GfG
{
    void countDistinct(int A[], int k, int n)
    {
	    for(int i=0; i<=n-k; i++) {
	        HashSet<Integer> s = new HashSet<Integer>();
	        for(int j=i; j<i+k; j++) {
	            s.add(A[j]);
	        }
	        System.out.print(s.size() + " ");
	    }	
    }
}
