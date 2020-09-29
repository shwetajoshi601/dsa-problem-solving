import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
    static int evaluatePostfix(String postfix) {
        if(postfix.length() == 0) return 0;
        
        // stack to store the operands
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<postfix.length(); i++) {
            char c = postfix.charAt(i);
            // System.out.println(c);
            if(Character.isDigit(c)) {
                // character is an operand
                // push it onto the stack
                st.push(Character.getNumericValue(c));
            } else {
                // character is an operator
                // pop two elements from the stack
                int op1 = st.pop();
                int op2 = st.pop();
                int res = 0;
                
                switch(c) {
                    // apply the operator on the two operands
                    // order of operands never changes during evaluation
                    // since we use a stack, the operand popped first is the one that appears later
                    // hence use op2 before op1
                    case '+': res = op2 + op1;
                    break;
                    case '-': res = op2 - op1;
                    break;
                    case '*': res = op2 * op1;
                    break;
                    case '/': res = op2 / op1;
                    break;
                }
                st.push(res);
            }
        }
        return (st.pop()).intValue();
    }
    
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int t = sc.nextInt();
	 sc.nextLine();
	 while(t-- > 0) {
	     String postfix = sc.nextLine().trim();
         // function call here
         System.out.println(evaluatePostfix(postfix));
	 	}
	 }
}