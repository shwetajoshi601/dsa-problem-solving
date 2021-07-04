class Pair {
    int val;
    int index;
    
    Pair(int value, int i) {
        val = value;
        index = i;
    }
}

class StackMaximumAreaRectangleInBinaryMatrix {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        
        int m = matrix.length, n = matrix[0].length;
        
        // we reduce this problem to the maximum area histogram problem
        // the first row forms one histogram
        int[] arr = new int[n];
        for(int j=0; j<n; j++)
            arr[j] = Character.getNumericValue(matrix[0][j]);
        
        // get the max area in this histogram
        int maxArea = largestRectangleArea(arr);
        
        // for the next rows, create new histograms by adding the values to the previous row
        // e.g. 0 1 1 0 -> row 1
        //      1 1 1 1 -> row 2
        // arr: 1 2 2 1 -> this is a histogram formed by row1 and row2 and we find its maximum area
        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                // if the below row value is 0, it does not add up to the height
                // and does not form a continuous rectangle
                // hence make the value 0
                if(matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                // add to the height
                    arr[j] = arr[j] + Character.getNumericValue(matrix[i][j]);
                }
            }
            
            // get the maximum area
            int area = largestRectangleArea(arr);
            System.out.println("Area: " + area);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
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