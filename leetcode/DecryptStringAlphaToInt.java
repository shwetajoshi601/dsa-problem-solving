class DecryptStringAlphaToInt {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int idx=0; idx < s.length(); idx++) {
            int num=0;
            
            // check if there is a # two characters from the current char
            if(idx+2 < s.length() && s.charAt(idx+2) == '#') {
                // parse the number
                num = Integer.parseInt(s.substring(idx, idx+2));
                // jump to the number after #
                idx+=2;
            } else {
                // parse only the current number
                num = Integer.parseInt(Character.toString(s.charAt(idx)));
            }
            
            // ascii of small letters begins from 97
            // in this problem, numbering begins from 1
            // to get the ascii value of each char -> num+96
            sb.append(Character.toChars(num+96));
        }
        
        return sb.toString();
    }
}