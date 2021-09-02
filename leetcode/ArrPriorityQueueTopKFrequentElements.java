import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length == 0) return null;
        List<Integer> result = new ArrayList<Integer>();
        
        // create a map with frequencies of each element
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        
        // create a map of frequency -> list of elements with that frequency
        Map<Integer, List<Integer>> valueMap = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());
        
        // iterate over the map of (element, frequency)
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            // if an entry for the frequency value exists
            if(valueMap.containsKey(e.getValue())) {
                // add the element in the list of corresponding elements
                valueMap.get(e.getValue()).add(e.getKey());
            } else {
                // frequency entry not present
                List<Integer> keys = new ArrayList<Integer>();
                keys.add(e.getKey());
                valueMap.put(e.getValue(), keys);
            }
        }
        
        // iterate over the map of (freq, list)
        // to get top k frequency elements
        for(Map.Entry<Integer, List<Integer>> e: valueMap.entrySet()) {
            // get the list
            List<Integer> vals = e.getValue();
            
            if(k > 0) {
                // if more than 1 elements have the same frequency
                if(vals.size() > 1) {
                    // find the max by sorting in descending order
                        Collections.sort(vals, Collections.reverseOrder());
                        Iterator<Integer> it = vals.iterator();
                    // get k values
                        while(it.hasNext() && k-- > 0) 
                            result.add(it.next());
                } else {
                    // only a single element with the frequency
                     result.add(vals.get(0));
                        k--;
                }
            } else
                // found k values
                break;
        }
        
        return result;
    }

    // Using Min Heap
    // O(n log k) / O(n + k) -> n is the no. of unique elements
    public int[] topKFrequentHeap(int[] nums, int k) {
        if(nums.length == 0) return null;
        int[] result = new int[k];
        
        // count the frequency of each number
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        // create a min heap containing k elements
        Queue<Integer> pq = new PriorityQueue<Integer>(k, (a, b)-> {
            return map.get(a)-map.get(b);
        });
        
        // add each unque value to the heap
        // it will be sorted in order of frequency
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            pq.add(e.getKey());
            // if the heap size exceeds k, remove an element
            // since its a min heap, the element removed will be of lower frequency
            // hence the heap always contains k most frequent elements
            if(pq.size() > k)
                pq.poll();
        }
        
        int i = 0;
        while(!pq.isEmpty())
            result[i++] = pq.poll();
        
        return result;
    }
}