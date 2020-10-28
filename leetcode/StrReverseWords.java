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
}