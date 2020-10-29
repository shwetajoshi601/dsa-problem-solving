/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class StackReverseUsingRecursion {
    
   static void reverseStack(Stack<Integer> st) {
       if(st.isEmpty()) return;
       // remove the top element
       int temp = st.pop();
       // reverse the remaining stack
       reverseStack(st);
       // add the removed element at the bottom
       insertAtBottom(st, temp);
   }
   
   static void insertAtBottom(Stack<Integer> st, int data) {
       if(st.isEmpty()) {
           st.push(data);
           return;
       }
       
       // pop the stack
       int temp = st.pop();
       // insert the given data at the bottom
       insertAtBottom(st, data);
       // push the removed element
       st.push(temp);
   }
    
	public static void main (String[] args) {
	    Stack<Integer> st = new Stack<Integer>();
	    st.push(1);
	    st.push(2);
	    st.push(3);
	    st.push(4);
	    
	    reverseStack(st);
	    
	    while(!st.isEmpty())
	        System.out.println(st.pop());
	}
}