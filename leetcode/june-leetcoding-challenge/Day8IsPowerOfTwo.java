public class Day8IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {

        if(n==1) return true;
        // negative numbers and zero
        if(n<=0) return false;
        
       while(n>1) {
           System.out.println(n%2);
           // powers of two are always even
           if(n%2 != 0)
               return false;
           n=n/2;
       }
    
        return true;
    }
}