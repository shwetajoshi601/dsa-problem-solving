import java.util.*;
import java.lang.*;
import java.io.*;

class RecGameOfDeathJosephus
 {
    // recursive solution
    static void findSurvivor(List<Integer> persons, int n, int k, int index) {
        // base condition when only 1 person remains
        if(persons.size() == 1) {
            System.out.println(persons.get(0));
            return;
        }
        
        // index denotes the index of the person to be killed
        // first, the kth person is killed, which means 0+k th index.
        // use % size to avoid overflowing. e.g. index = 3, k=3 and n=5, the next index would be 6 which is out of bounds
        // hence 6%5 = 1, hence circle back to index 1 
        index = (index+k) % persons.size();
        // remove the person at the index
        persons.remove(index);
        // now count k persons from the index k and repeat
        findSurvivor(persons, n, k, index);
    }
    
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int t = sc.nextInt();
	 
	 while(t-- > 0) {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	    
	    List<Integer> persons = new ArrayList<Integer>();
	    // create an array list to represent the persons from 1 to n
	    for(int i=1; i<=n; i++)
	        persons.add(i-1, i);
	        // kth person means person at index k-1, to align with 0 based indexing reduce by 1
	        k=k-1;
            // the start index for counting will be from 0
            findSurvivor(persons, n, k, 0);
	 	}
	 }
}