import java.util.*;

class ArrUniqueNoOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // create a hashmap to store element frequencies
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        // create a set from the values
        List<Integer> valuesList = new ArrayList<Integer>(map.values());
        Set<Integer> valuesSet = new HashSet<Integer>(valuesList);
        
        // if the set size is less than the size of the list,
        // there are duplicate frequencies
        // if size is the same, there are unique frequencies
        if(valuesList.size() == valuesSet.size())
            return true;
        
        return false;
    }
}