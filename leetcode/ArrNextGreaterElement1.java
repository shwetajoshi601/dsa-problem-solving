import java.util.*;

public class ArrNextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        if(nums1.length==0 || nums2.length==0) return new int[0];
        
        Stack<Integer> st=new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // for each element, we check if it is greater than the element on the stack
        // if yes, this element is the next greater element for all numbers less than the element on top, pop this element from the stack
        // e.g: [5,4,3,2,1,8] -> 8 is the NGE for all elements before it
        // keep adding elements in the stack until a number greater than all numbers is found
        for(int n: nums2) {  
            while(!st.empty() && st.peek() < n)
                // store the NGE for each element
                map.put(st.pop(), n);
            
            st.push(n);
        }
        
        int[] res=new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            res[i]=map.getOrDefault(nums1[i], -1);
        }
        
        return res;
    }
}