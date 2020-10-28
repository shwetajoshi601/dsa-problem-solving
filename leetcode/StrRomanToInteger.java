class StrRomanToInteger {
    int getValue(char c) {
        int val = 0;
        switch(c) {
                case 'I': val = 1;
                    break;
                case 'V': val = 5;
                    break;
                case 'X': val = 10;
                    break;
                case 'L': val = 50;
                    break;
                case 'C': val = 100;
                    break;
                case 'D': val = 500;
                    break;
                case 'M': val = 1000;
                    break;
            }
        return val;
    }

    public int romanToInt(String s) {
        int num=0;
        
        if(s.length() == 1) return getValue(s.charAt(0));
        
        for(int i=0;i<s.length();i++) {
            int curr = getValue(s.charAt(i));
            if(i+1 < s.length()) {
                int next = getValue(s.charAt(i+1));
                // compare next character
                if(curr >= next) {
                    // XX
                    num = num + curr;
                } else {
                    // IV, IX
                    num = num + next - curr;
                    i++;
                }
            } else {
                // last
                num = num + curr;
                i++;
            }
        }
        return num;
    }

    // function to get integer value of roman characters
    int value(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return -1;
    }
    
    // simple if-else function, same approach
    public int romanToInt2(String s) {
        int result = 0;
        
        for(int i=0; i<s.length(); i++) {
            // check for 6 subtraction cases
            if(i!=s.length()-1 && 
            ((s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) || 
            (s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) || 
            (s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')))) {
                // subtract the current value from the next
                // usual -> large value first; in these cases, small value appears first
                result+= (value(s.charAt(i+1)) - value(s.charAt(i)));
                i++;
            } else
                // other cases - just add the integer value
                result+=value(s.charAt(i));
        }
        
        return result;
    }
}