class Pair {
    int val;
    int index;
    
    Pair(int value, int i) {
        val = value;
        index = i;
    }
}

class StacksMaximumAreaHistogram {
    public int largestRectangleArea(int[] heights) {
        // area can be found only if adjacent bars are of height >= current bar
        // to find the boundary, we need to stop when there is a smaller element
        // on the left and right
        int[] left = getNearestSmallerToLeft(heights);
        int[] right = getNearestSmallerToRight(heights);
        
        int maxArea = 0;
        
        // once we have indexes of the left and right smaller elements for each height
        // we calculate the width and the area
        for(int i=0; i<heights.length; i++) {
            // to find the width, we need to exclude the indexes of smaller elements
            // hence subtract 1
            // consider first example, index of 1 = 1, index of 2 = 4
            // 4-1 = 3, but actual no. of bars is 2.
            int width = right[i] - left[i] - 1;
            // area = lxb
            int area = width * heights[i];
            
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    int[] getNearestSmallerToLeft(int[] heights) {
        // in case there is no smaller element
        int pseudoIndex = -1;
        // Stack of pairs
        Stack<Pair> st = new Stack<Pair>();
        // result
        int[] res = new int[heights.length];
        
        for(int i=0; i<heights.length; i++) {
            while(!st.isEmpty() && st.peek().val >= heights[i])
                st.pop();
            
            // we want the index of the smaller element
            if(st.isEmpty())
                res[i] = pseudoIndex;
            else
                res[i] = st.peek().index;
            
            st.push(new Pair(heights[i], i));
        }
        
        return res;
    }
    
    int[] getNearestSmallerToRight(int[] heights) {
        // in case there is no smaller element
        int pseudoIndex = heights.length;
        // Stack of pairs
        Stack<Pair> st = new Stack<Pair>();
        // result
        int[] res = new int[heights.length];
        
        for(int i=heights.length-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek().val >= heights[i])
                st.pop();
            
            // we want the index of the smaller element
            if(st.isEmpty())
                res[i] = pseudoIndex;
            else
                res[i] = st.peek().index;
            
            st.push(new Pair(heights[i], i));
        }
        
        return res;
    }
}