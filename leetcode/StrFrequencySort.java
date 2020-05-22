import java.util.*;

public class StrFrequencySort {
    public String frequencySort(String s) {
        if(s.length()==0 || s.length()==1)
            return s;
        
        // build a frequency map
        Map<Character, Integer> map=new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        
        StringBuilder sb=new StringBuilder();
        
        // build a max heap using priorityQueue based on the frequency count
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        
        // for each character in the heap
        while(!maxHeap.isEmpty()) {
            // remove the top
            char current=maxHeap.remove();
            // append as many times as its frequency
            for(int i=0; i<map.get(current); i++)
                sb.append(current);
        }
        
        return sb.toString();
    }
}