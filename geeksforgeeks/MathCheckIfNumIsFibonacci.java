// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class MathCheckIfNumIsFibonacci
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.checkFibonacci(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String checkFibonacci(int N){
        // a number is a fibonacci number if 5n^2-4 or 5n^2 + 4 is a perfect square
        boolean result = isPerfectSquare(5*N*N+4) || isPerfectSquare(5*N*N-4);
        
        if(result)
            return "Yes";
        else
            return "No";
    }
    
    static boolean isPerfectSquare(int num) {
        // calculate the square root
        double sq = Math.sqrt(num);
        
        // get the nearest smaller value using floor
        double sq_floor = Math.floor(sq);
        
        
        // the number is a perfect square if the difference of the two is zero
        return (sq-sq_floor)==0;
        
        // alternate way: int sq_root=(int)(Math.sqrt(num)); return sq_root*sq_root == num;
    }
}
