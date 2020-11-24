class MathConvertExcelSheetColumnToTitle {
    public String convertToTitle(int n) {
        String res = "";
        
        while(n > 0) {
            char c = (char)('A' + (n-1)%26);
            res = c + res;
            n = (n-1)/26;
        }
        
        return res;
    }
}