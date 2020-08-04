import java.util.*;
import java.lang.*;
import java.io.*;

public class StackInfixToPostfix
 {
    public static int Prec(char c) {
        // returns the precedence of an operator
        switch(c) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '^':
                return 2;
        }
        
        return -1;
    } 
    
    public static String infixToPostfix(String exp) {
        // System.out.println("Expression: " + exp);
        
        String result = "";
        
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0; i<exp.length(); i++) {
            char c = exp.charAt(i);
            
            // If the character is an operand, append it to the result
            // in postfix operands come first
            if(Character.isLetterOrDigit(c))
                result += c;
            else if(c == '(')
            // open bracket found, push onto the stack
                st.push(c);
            else if(c == ')') {
            // if a closing bracket is found, pop all the elements from the stack
            // until the corresponding open bracket is found
                while(!st.isEmpty() && st.peek() != '(')
                    result += st.pop();
                // pop the open bracket (need not be added to the result)
                st.pop();
            } else {
                // operator found
                // pop all the elements with precedence higher than the current operator
                while(!st.isEmpty() && Prec(c) <= Prec(st.peek()))
                    result+=st.pop();
                // push the operator onto the stack
                st.push(c);
            }
        }
        
        // once the expression is parsed
        // the stack may contain operators
        // pop the operators and add them to the result
        while(!st.isEmpty())
            result+=st.pop();
            
        return result;
    }
     
	public static void main (String[] args)
	 {
	    //code
	    Scanner sc = new Scanner(System.in);
	    int t = Integer.parseInt(sc.nextLine());
	    
	    while(t-- > 0) {
	        String s = sc.nextLine();
	        System.out.println(infixToPostfix(s));
	    }
	 }
}