class ArrCompressString {
    public int compress(char[] chars) {
        int i=0,j=0,index=0;
        
        while(i < chars.length) {
            // move ahead till a different character is found
            while(j < chars.length && chars[i]==chars[j])
                j++;
            
            // index denotes the current position
            // add the character at the current position
            chars[index++]=chars[i];
            
            // character count
            // if i=0 and j=5, that means the element at 0 occurred 5 times - (j-i)
            // we do not add the count for single characters, only for multiple occurences
            if(j-i > 1) {
                // convert to string
                String count= (j-i) + "";
                // if count is 12, the characters are 1, 2, both are added at distinct locations
                for(char c: count.toCharArray()) {
                    chars[index++]=c;
                }   
            }
            // process the next character
            i=j;
        }
        
        // finally, the total length will be the position of index
        return index;
    }
}