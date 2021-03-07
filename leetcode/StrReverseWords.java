class StrReverseWords {
    public String reverseWords(String s) {
        if(s.length() == 0) return s;
        // \\s+ is used to match multiple spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< words.length; i++) {
            // if(words[i].length() !=0)
            // words array contains only words without spaces
            // add the word at the beginning (to create reverse string)
            sb.insert(0, words[i]);
            if(i!=words.length-1)
                sb.insert(0, " ");
        }
        
        return sb.toString();
    }

    // similar solution using java methods
    // O(n) time, O(n) space
    public String reverseWords(String s){
        // split the string on space characters
        String[] words = s.trim().split("\\s+");
        // reverse the array of words
        Collections.reverse(Arrays.asList(words));
        
        // convert to a string joined by space
        return String.join(" ", words);
    }

    // using two pointer
    public String reverseWordsTwoPointer(String s) {
        int i = 0;
        int len = s.length();
        
        String result = "";
        
        while(i < len) {
            // skip space charactes
            while(i < len && s.charAt(i) == ' ')
                i++;
            
            // now i is at a non-space character - start of a word
            int j = i;
            // find the end of the word
            while(j < len && s.charAt(j) != ' ')
                j++;
            
            // pick the word
            String word = s.substring(i, j);
            System.out.println(word);
            
            // add to the result
            result = result.length() == 0 ? word : word + " " + result;
            // move to the next character afte the previous word
            i = j + 1;
        }
        
        return result.trim();
    }
}