import java.util.*;

class MinIndexSumLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        if(list1.length == 0 || list2.length == 0)
            return new String[0];
        
        int min = Integer.MAX_VALUE;
        ArrayList<String> res = new ArrayList<String>();
        
        // first list
        for(int i=0; i<list1.length; i++) {
            // second list
            for(int j=0; j<list2.length; j++) {
                
                // if values are equal
                // note the usage of .equals() - == would return false since they are different objects
                if(list1[i].equals(list2[j])) {
                    
                    // if their sum index is minimum
                    if((i+j) <= min) {
                        
                        // add it to the results list
                        res.add(list2[j]);
                        min = i+j;
                    }
                }
            }
        }
        
        return res.toArray(new String[res.size()]);
    }
}