import java.util.*;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        // to get unique city names
        Set<String> set = new HashSet<String>();
        
        // iterate over all paths
        Iterator<List<String>> itr = paths.iterator();
        while(itr.hasNext()) {
            // form a set
            List<String> p = itr.next();
            for(String city: p)
                set.add(city);
        }
        
        String res="";
        
        // total no. of paths
        int pathsSize=paths.size();
        
        // for each unique city
        for(String c: set) {
            int count=0;
            // each path
            for(List<String> path: paths) {
                // check if it is not present in the source of the path
                if(!path.get(0).equals(c)) {
                    // increment count
                    count++;
                    // check if this count is equal to the number of paths
                    if(count == pathsSize)
                    {
                        res=c;
                        break;
                    }
                }
            }
        }

        /**
         * Another approach would be to create a map of source and dest in paths.
         * For each city check if the city appears in key
         * If it doesnt it is the destination
         */
         return res;
    }
}