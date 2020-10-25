/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class MathFindNextFibonacciNumber {
    
    public static long findNextFibonacci(int N) {
        // the ratio between two adjacent fibonacci numbers approaches: (1+sqrt(5))/2.
        // Considering x as the next fibonacci and N as the last fibonacci number known,
        // x/N = (1+sqrt(5))/2, hence, x = N*(1+sqrt(5))/2
        
        return Math.round(N*(1+Math.sqrt(5))/2);
    }
    
	public static void main (String[] args) {
	    int N = 5;
	    
	    System.out.println(findNextFibonacci(N));
	}
}