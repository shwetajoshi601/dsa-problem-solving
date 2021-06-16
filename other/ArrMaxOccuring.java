import java.util.*;

public class ArrMaxOccuring {
    
    static int findMaxOccurring(int[][] sets) {
       if(sets.length == 0) return -1;
       
       int maxCount = 0, value=-1;
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
       
       // since the given arrays are sets, each element will only appear once in each set
       // frrequency count gives the number of sets each element occurs in
       for(int i=0; i<sets.length; i++) {
           for(int j=0; j<sets[i].length; j++) {
                map.put(sets[i][j], map.getOrDefault(sets[i][j], 0)+1);
           }
       }
       
       // find the max by iterating through the map
       for(Map.Entry<Integer, Integer> e: map.entrySet()) {
           int freq = e.getValue();
           // current freq greater than the max
           if(freq > maxCount) {
               // update the freqeuncy and value
               maxCount = freq;
               value = e.getKey();
           } else if(freq == maxCount) {
               // if two numbers appear in the same number of max sets
               // pick the number that is smaller
               value = Math.min(value, e.getKey());
           }
       }
       
       // return the number
       return value;
    }
    
    public static void main(String args[]) {
        int[][] sets = {{2, 3, 4, 5}, {1, 3, 6, 7}, {0, 8, 9, 6}};
        
        System.out.println(findMaxOccurring(sets));
    }
}