class Solution {
    public int reverse(int x) {
        // to avoid overflow
        long rev = 0;
        while(x!= 0) {
            // units digit
            int num = x % 10;
            rev = rev*10 + num;
            x = x/10;
        }
        
        // check the range of the reversed number
        if(rev <= (long)Integer.MAX_VALUE && rev >= (long)Integer.MIN_VALUE)
            return (int)rev;
        else
            return 0;
    }
}