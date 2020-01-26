class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0; i< words.length-1; i++) {
            // adjacent words
            String word1 = words[i];
            String word2 = words[i+1];
            int i1=0, i2=0;
            
            // find the length of the shorter word
            int shortLen = word1.length() < word2.length() ? word1.length() : word2.length();

            // move ahead till you find an unequal character in both words
            while(shortLen-- > 0 && word1.charAt(i1) == word2.charAt(i2)) {
                i1++;
                i2++;
            }
            
            // if one word is shorter than the other and has ended, then its index in dictionary would be -1
            // else the index of the unequal character
            int order_i1 = i1 >= word1.length() ? -1 : order.indexOf(word1.charAt(i1));
            int order_i2 = i2 >= word2.length() ? -1 : order.indexOf(word2.charAt(i2));
            
            // if the char in first word is after the char in second word
            if(order_i1 > order_i2)
                return false;
        }
        return true;
    }
}