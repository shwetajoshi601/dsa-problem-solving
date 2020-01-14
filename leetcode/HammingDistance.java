class HammingDistance {
    String convertToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, Integer.toString(num%2));
            num = num / 2;
        } while(num != 0);
        return sb.toString();
    }
    
    String addZeroPadding(String num, int diff) {
        StringBuilder sb = new StringBuilder(num);
        while(diff-- >0) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
    
    public int hammingDistance(int x, int y) {
        int distance = 0;
        String num1 = convertToBinary(x);
        String num2 = convertToBinary(y);
        
        if(num1.length() > num2.length())
            num2 = addZeroPadding(num2, Math.abs(num1.length() - num2.length()));
        else
            num1 = addZeroPadding(num1, Math.abs(num1.length() - num2.length()));
        
        for(int i=0; i< num1.length(); i++) {
            if(num1.charAt(i) != num2.charAt(i))
                distance++;
        }
        return distance;
    }
}