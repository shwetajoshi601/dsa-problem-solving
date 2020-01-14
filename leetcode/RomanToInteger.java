class RomanToInteger {
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
}