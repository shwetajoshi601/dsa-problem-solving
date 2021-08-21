// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class HeapMergeTwoBinaryMaxHeaps {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long a[] = new long[(int)(n)];
            long b[] = new long[(int)(m)];
            long merged[] = new long[(int)(n+m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Compute obj = new Compute();
            obj.maxProfit(merged, a, b, n, m);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n+m;i++)
                output.append(merged[i]+" ");
            System.out.println(output);
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Compute {
    void heapify(long[] arr, long n, int i) {
        if(n == 0 || n == 1)
            return;
            
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;
        
        if(left < n && arr[left] >= arr[largest])
            largest = left;
            
        if(right < n && arr[right] >= arr[largest])
            largest = right;
            
        if(largest != i) {
            // swap with the smaller child
            swap(arr, i, largest);
            // heapify the element at smallest
            heapify(arr, n, largest);
        }
    }
    
    void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void maxProfit(long merged[], long a[], long b[], long n, long m) {
        int i = 0;
        for(; i<n; i++)
            merged[i] = a[i];
            
        for(i=0;i<m; i++)
            merged[(int)n+i] = b[i];
            
        for(i=(int)(m+n)/2; i>=0; i--)
            heapify(merged, m+n, i);
    }
}