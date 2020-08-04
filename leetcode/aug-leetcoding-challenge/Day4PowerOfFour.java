class Day4PowerOfFour {
    public boolean isPowerOfFour(int num) {
        // repeatedly divide the number by 4
        while(num > 1) {
            // if at any point it is not divisible by 4, it is not a power of 4
            if(num % 4 != 0) return false;
            num = num / 4;
        }
        
        // after being completely divided by 4, the final number should be 1
        return num == 1;
    }

    public boolean isPowerOfFourUsingLogs(int num) {
        // if the number is a power of 4 the below expression should return an integer.
        // for e.g. num = 16,
        // log(16)/log(4) = 2 
        // => 16 = 4^2 
        // => taking logs, log(16) = log(4^2) => log(16) = 2.log(4) 
        // => log(16)/log(4) = 2  
        double ans = Math.log(num) / Math.log(4);
        
        // check if the number returned is an integer
        // you could also do -> (int)ans == ans
        return ans % 1 == 0;
    }
}