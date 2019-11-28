import java.util.*;
import java.lang.*;
import java.io.*;
class NextGreaterElement
 {
    /*static class Stack {
        int top = -1;
        int[] items = new int[99];
        
        void push(int element) {
            if(top == 99) {
                System.out.println("Stack overflow");
            } else {
                items[++top] = element;
            }
        }
        
        int pop() {
            int element = 0;
            if(top == -1) {
                System.out.println("Stack underflow");
            } else {
                element = items[top];
                top--;
            }
            return element;
        }
        
        boolean isEmpty() {
            return (top == -1 ? true : false);
        }
    }*/

    public static void getNextLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<Integer>();
        int element = 0;
        Map<Integer, Integer> res= new LinkedHashMap<Integer, Integer>(); 
        for(Integer i: arr) {
            res.put(i, 0);
        }
        st.push(arr[0]);
        
        for(int i=1; i<arr.length;i++) {
            int next = arr[i];
            if(!st.empty()) {
                element = st.pop();
                while(element < next) {
                    res.put(element, next);
                    // System.out.print(next + " ");
                    if(st.empty()) break;
                    element = st.pop();
                }
                if(element > next) st.push(element);
            }
            st.push(next);
        }
        
        while(!st.empty()) {
            element = st.pop();
            res.put(element, -1);
            // System.out.print(-1 + " ");
        }
        
         // using for-each loop for iteration over Map.entrySet() 
        for (Map.Entry<Integer,Integer> entry : res.entrySet())  
            System.out.print(entry.getValue() + " "); 
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