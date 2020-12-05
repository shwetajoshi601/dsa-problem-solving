class StrRemoveAdjacentDuplicates {
    public String removeDuplicates(String S) {
        if(S.length() == 1) return S;
        
        int i = 0;
        // use like a stack
        char[] chars = new char[S.length()];
        
        for(int j=0; j<S.length(); j++) {
            char currentChar = S.charAt(j);
            
            // if there is an element in the stack
            // compare with the current char
            if(i>0 && chars[i-1] == currentChar) {
                // if they are equal, remove it from the stack (the next current element is the previous char)
                i--;
            } else {
                // if not equal, add in the stack
                chars[i] = currentChar;
                i++;
            }
        }
        
        // return the string in the stack
        return new String(chars, 0, i);
    }
}