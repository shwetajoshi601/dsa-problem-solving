// { Driver Code Starts
    import java.util.*;

    class Merge_Sort
    {
        //method to print the elements of the array
        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    
        //method for dividing the array into halves
        static void mergeSort(int arr[], int l, int r)
        {
            SortMerge g = new SortMerge();
            if (l < r)
            {
                int m = (l+r)/2;
                mergeSort(arr, l, m);
                mergeSort(arr , m+1, r);
                g.merge(arr, l, m, r);
            }
        }
    
        public static void main(String args[])
        {
            //taking input using Scanner class
            Scanner sc = new Scanner(System.in);
            
            //taking testcases
            int T = sc.nextInt();
            while(T>0)
            {
                //taking elements count
                int n = sc.nextInt();
                
                //creating an object of class Merge_Sort
                Merge_Sort ms = new Merge_Sort();
                
                //creating an array of size n
                int arr[] = new int[n];
                
                //adding elements to the array
                for(int i=0;i<n;i++)
                    arr[i] = sc.nextInt();
    
                
                SortMerge g = new SortMerge();
                
                //calling the method mergeSort
                mergeSort(arr,0,arr.length-1);
    
                //calling the method printArray
                ms.printArray(arr);
            T--;
            }
        }
    }
    
    
    // } Driver Code Ends
    
    
    /* The task is to complete merge() which is used
    in below mergeSort() */
    class SortMerge
    {
       // Merges two subarrays of arr[].  First subarray is arr[l..m]
       // Second subarray is arr[m+1..r]
        void merge(int arr[], int l, int m, int r)
        {
        // create temp arrays for left and right subarrays
         int len1=m-l+1;
         int len2=r-m;
         int left[] = new int[len1];
         int right[] = new int[len2];
         
         // add elements in left array (starts from l)
         for(int i=0; i<len1; i++)
            left[i] = arr[l+i];
        
        // add elements in right array (starts from m+1)
         for(int j=0; j<len2;j++)
            right[j] = arr[m+1+j];
        
        // traverse the elements
         int k=l, i=0, j=0;
         while(i < len1 && j<len2) {
             // left array has a smaller element
             if(left[i] < right[j])
                arr[k++] = left[i++];
             else
             // right array has a smaller element
                arr[k++] = right[j++];
         }
         
         // add remaining elements from left subarray
         while(i<len1)
            arr[k++]=left[i++];
            
        // add remaining elements from right subarray
         while(j<len2)
            arr[k++]=right[j++];
        }
    }
    
     /* This method is present in a class other than SortMerge class .
    static void mergeSort(int arr[], int l, int r)
     {
        SortMerge g = new SortMerge();
        if (l < r)   
       {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            g.merge(arr, l, m, r);
        }
    }*/