class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // empty array
        if(strs.length == 0)
            return "";
        
        // one element
        if(strs.length == 1)
            return strs[0];
        
        String longest = strs[0];
        
        //string array
        for(int i=1; i<strs.length; i++) {
            
            // compare the two strings
            // only traverse characters upto the mini length among two string to avoid IndexOutOfBound
            int maxLength = Math.min(longest.length(), strs[i].length());
            StringBuilder sb = new StringBuilder();
            
            // character in each string
            for(int j=0; j<maxLength; j++) {
                
                if(strs[i].charAt(j) == longest.charAt(j))
                    // common character found
                    sb.append(Character.toString(longest.charAt(j)));
                else
                    // not found
                    break;
            }
            
            String common = sb.toString();
            // take only the common string
            longest = common.length() < longest.length() ? common : longest;
            // no common characters found, stop
            if(common.length() == 0)
                break;
        }
        
        return longest;
    }
} 