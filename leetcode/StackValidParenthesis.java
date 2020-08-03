class StackValidParenthesis {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        
        if(s.length() == 1)
            return false;
        
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0; i< s.length(); i++) {
            char currChar = s.charAt(i);
            // push if opening bracket
            if(currChar == '(' || currChar == '[' || currChar == '{')
                st.push(currChar);
            else {
                // closing bracket
                // if the there is no corresponding opening bracket in the stack
                if(st.isEmpty())
                    return false;
                
                // get the last opening bracket
                char top= st.pop();
                
                // if it does not match, return false
                if((currChar == ')' && top != '(') || (currChar == ']' && top != '[') || (currChar == '}' && top != '{'))
                    return false;
            }
        }
        
        // if the stack is empty means exact matches -> (( - will only perform push operation, hence the stack would contain elements which is invalid
        boolean flag = st.isEmpty() ? true : false;
        
        return flag;
    }
}