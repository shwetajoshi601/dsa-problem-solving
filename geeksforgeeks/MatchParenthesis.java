import java.util.*;
import java.lang.*;
import java.io.*;
class MatchParenthesis
 {
    static boolean matchParentheses(char[] exp) {
        Stack<Character> st = new Stack<Character>();

        //false --> not matching 
        //true --> matching
        for(int i=0;i<exp.length;i++) {
            if(exp[i] == '(' || exp[i] == '{' || exp[i]  == '[')
                st.push(exp[i]);
            
            if(exp[i] == ')' || exp[i] == '}' || exp[i] == ']') {
                if(st.empty())
                    return false;
                else if(exp[i] == ')' && st.peek() == '(')
                    st.pop();
                else if(exp[i] == '}' && st.peek() == '{')
                    st.pop();
                else if(exp[i] == ']' && st.peek() == '[')
                    st.pop();
                else
                    return false;
            }
        }
        if(st.empty())
            return true;
        else
            return false;
    }
    
	public static void main (String[] args)
	 {
	    Scanner obj = new Scanner(System.in);
	    int tc = Integer.parseInt(obj.nextLine());
	    while(tc-- >0) {
	        String parentheses = obj.nextLine();
	        char[] exp = parentheses.toCharArray();
	        if(matchParentheses(exp))
	            System.out.println("balanced");
	       else
	            System.out.println("not balanced");
	    }
	    obj.close();
	 }
}