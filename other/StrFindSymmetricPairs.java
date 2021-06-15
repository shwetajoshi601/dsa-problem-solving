import java.util.*;

public class SymmetricPairs {
    static int[][] findSymmetricPairs(int[][] arr) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i][0]) && arr[i][1] == map.get(arr[i][0])) {
                // found pair
                int[] pair1 = {arr[i][1], arr[i][0]};
                // int[] pair2 = {arr[i][0], arr[i][1]};
                result.add(pair1);
                // result.add(pair2);
            }
            
            map.put(arr[i][1], arr[i][0]);
        }
        
        return result.toArray(new int[0][]);
    }
    
    static void print(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.println("(" + arr[i][0] + "," + arr[i][1] + ")");
        }
    }
    
    public static void main(String args[]) {
        
        int[][] arr = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
        print(findSymmetricPairs(arr));
       
    }
}