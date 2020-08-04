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
}