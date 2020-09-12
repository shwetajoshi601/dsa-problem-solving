class MathPowXN {
    // gives TLE - exponential
    public double myPowBrute(double x, int n) {
        double result = 1;
        int count = Math.abs(n);
        
        while(count-- >= 1)
            result = result*x;
        
        if(n < 0)
            result = 1/result;
        
        return result;
    }

    // O(log n)
    public double myPowOptimal(double x, int n) {
        double result = 1.0;
        long nn = n;
        // if n is negative make it positive
        if(nn<0) nn = nn*(-1);
        
        // when n is odd - reduce n by 1, to get an even number
        // multiple the result by x
        while(nn > 0) {
            if(nn % 2 == 1) {
                result = result * x;
                nn=nn-1;
            } else {
                // when n is even - reduce n to half
                // square the value of x
                x=x*x;
                nn=nn/2;
            }
        }
        
        // x^(-n) = 1/x^n
        if(n<0) result = (double)1.0/(double)result;
        
        return result;
    }
}