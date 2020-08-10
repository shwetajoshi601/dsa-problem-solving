class Day10ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int total = 0;
        
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            // convert character to number
            int num = c - 'A' + 1;
            // converting a number with base 26
            total = total*26 + num;
        }
        
        return total;
    }
}