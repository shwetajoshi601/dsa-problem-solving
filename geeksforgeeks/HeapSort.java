
    import java.util.*;
    class HeapSort
    {
        void printArray(int arr[],int n)
        {
            //int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i]+" ");
            System.out.println();
        }
        public static void main(String args[])
        {
            Scanner sc  = new Scanner(System.in);
            Heap_Sort hs = new Heap_Sort();
            int arr[] = new int[1000000];
            int T = sc.nextInt();
            while(T>0)
            {
                int n = sc.nextInt();
                for(int i=0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                Solution ob=new Solution();
                ob.heapSort(arr,n);
                hs.printArray(arr,n);
                T--;
            }
        }
        
    }
    
    
    // } Driver Code Ends
    
    
    class Solution
    {
        //Function to build a Heap from array.
        void buildHeap(int arr[], int n)
        {
            // a heap is a complete binary tree
            // in a complete binary tree, n/2 nodes are leaves. Leaf nodes are heaps by themselves
            // hence we only need to heapify excluding leaves
            for(int i=n/2; i>=0; i--)
                heapify(arr, n, i);
        }
     
        //Heapify function to maintain heap property.
        void heapify(int arr[], int n, int i)
        {
            // index of left and right child
            int left = 2*i + 1;
            int right = 2*i + 2;
            // set i as the current largest element index
            int largest = i;
            
            // update the largest if left child > than arr[i]
            if(left < n && arr[left] >= arr[largest])
                largest = left;
            
            // update if right child is the greatest
            if(right < n && arr[right] >= arr[largest])
                largest = right;
            
            // if one of the child nodes is greater,
            // we need to swap and bring it to the current position
            if(largest != i) {
                // recursively heapify the element at the new index
                swap(arr, i, largest);
                heapify(arr, n, largest);
            }
        }
        
        // Function of swap two elements in an array
        void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        //Function to sort an array using Heap Sort.
        public void heapSort(int arr[], int n)
        {
            if(n == 0 || n == 1)
                return;
                
            // build a heap
            buildHeap(arr, n);
            
            // delete all elements and heapify
            for(int i = n-1; i >= 1; i--) {
                // the first element is the largest
                // swap this with the current last element -> now the largest number is at the last
                swap(arr, 0, i);
                // now heapify the number at position 0, reduce the heap size to ensure
                // the sorted elements are not touched
                heapify(arr, --n, 0);
            }
        }
     }
     
     
    