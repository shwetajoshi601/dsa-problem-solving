// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class StackStockSpanProblem
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n =sc.nextInt();
                int a[] = new int[n];
                
                int i = 0;
                for(i = 0; i < n; i++)
                  a[i] = sc.nextInt();
                  
                int[] s = new Solution().calculateSpan(a, n);
                
                for(i = 0; i < n; i++)
                {
                    System.out.print(s[i] + " ");
                }
                
                System.out.println();
            }
        }
        
        
        
    }// } Driver Code Ends
    
    
    class Pair {
        int val;
        int index;
        
        Pair(int value, int i) {
            val = value;
            index = i;
        }
    }
    
    class Solution
    {
        //Function to calculate the span of stockâ€™s price for all n days.
        public static int[] calculateSpan(int price[], int n)
        {
            // Your code here
            Stack<Pair> st = new Stack<Pair>();
            int[] result = new int[n];
            
            // counting small elements is as good as finding the first greater
            // element to the left. To count, we need to store the indexes.
            for(int i=0; i<n; i++) {
                
                // pop the elements until a greater element is found
                while(!st.isEmpty() && st.peek().val <= price[i])
                    st.pop();
                    
                // stack empty means all elements to the left
                // are smaller than price[i]
                if(st.isEmpty())
                    result[i] = i+1;
                else
                    result[i] = (i - st.peek().index);
    
                st.push(new Pair(price[i], i));
            }
            
            return result;
        }
        
    }