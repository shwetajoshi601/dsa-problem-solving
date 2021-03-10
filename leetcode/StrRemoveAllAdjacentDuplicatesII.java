class StrRemoveAllAdjacentDuplicatesII {
    public String removeDuplicates(String s, int k) {
        // pair of character and count
        Stack<Pair> st = new Stack<Pair>();
        
        for(char c: s.toCharArray()) {
            // if there are chars in stack
            //check if its equal to the current char
            if(!st.isEmpty() && st.peek().c == c) {
                // increment its count
                st.peek().freq++;
            } else {
                // new character, push onto the stack
                st.push(new Pair(c, 1));
            }
            
            // if the char appears k times
            // remove it
            if(st.peek().freq == k)
                st.pop();
        }
        
        // construct the string
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()) {
            Pair curr = st.pop();
            // append the char according to its frequency
            for(int i=0; i<curr.freq; i++) {
                // first character is last in the stack
                // hence insert each char at pos 0
                sb.insert(0, curr.c);
            }
        }
        
        return sb.toString();
    }
}

// class to represent a pair
public class Pair {
    char c;
    int freq;
    
    Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}