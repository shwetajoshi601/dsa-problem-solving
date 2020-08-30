import java.io.*;
import java.util.*;

class GFG {
    
    static int findNonRepeatingNumber(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);   
        }
        
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue() == 1) {
                result = e.getKey();
                break;
            }
        }
        
        return result;
    }
    
	public static void main (String[] args) {
	    int[] arr = new int[]{-1,2,-1,3,2};
		int result = findNonRepeatingNumber(arr);
		
		System.out.println(result);
	}
}