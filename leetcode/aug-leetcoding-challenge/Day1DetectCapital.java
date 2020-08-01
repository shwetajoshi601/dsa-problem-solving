class Day1DetectCapital {
    public boolean detectCapitalUse(String word) {
        // empty string
        if(word.length() == 0)
            return true;
        
        boolean flag = false;
        
        // first character is capital
        if(Character.isUpperCase(word.charAt(0)))
            flag = true;
        
        int capitalCount = 0;
        
        // check the remaining characters
        for(int i=1; i < word.length(); i++) {
            char currChar = word.charAt(i);
            // count the number of capital characters
            if(Character.isUpperCase(currChar))
                capitalCount++;
        }

        if(capitalCount == word.length()-1 && flag == true)
            // all characters are capital
            return true;
        if(capitalCount == 0)
            // all remaining characters are lowercase
            // return true if the first character is upper or lower case
            return true;
        
        return false;
    }
}