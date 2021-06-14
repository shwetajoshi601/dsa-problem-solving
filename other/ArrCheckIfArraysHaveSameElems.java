import java.util.*;

public class CheckIfArraysHaveSameElems {
    static boolean checkElements(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) return false;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: arr1)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        for(int i=0; i<arr2.length; i++) {
            if(map.containsKey(arr2[i])) {
                if(map.get(arr2[i]) == 0) return false;
                map.put(arr2[i], map.get(arr2[i])-1);
            } else
                return false;
        }
        
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue() > 0) return false;
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        // int[] arr1 = {2, 5, 6, 8, 10, 2, 2};
        // int[] arr2 = {2, 5, 5, 8, 10, 5, 6};
        
        int[] arr1 = {2, 5, 6, 8, 10, 2, 2};
        int[] arr2 = {2, 5, 2, 8, 10, 2, 6};
        
        System.out.println(checkElements(arr1, arr2));
    }
}