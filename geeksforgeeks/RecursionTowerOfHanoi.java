// { Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class RecursionTowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}





// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {
    int count = 0;
    
    void printMsg(int disk, int from, int to) {
        System.out.println("move disk " + disk + " from rod " + from + " to rod " + to);
    }
    
    public long toh(int N, int from, int to, int aux) {
        count++;
        // if there is only one disk, it can be moved to the destination directly
        if(N == 1) {
            printMsg(N, from, to);
            return count;
        }
        
        // for N disks, we can move the first N-1 disks to an aux rod
        toh(N-1, from, aux, to);
        // then only one disk remains in the from rod. This can be moved to the to rod
        printMsg(N, from, to);
        // now move the n-1 disks back from the aux to destination rod using the the remaining one as the auxiliary
        toh(N-1, aux, to, from);
        
        return count;
    }
}
