import java.util.*;

class ArrPascalsTriangle {

    public List<List<Integer>> generateBetterSoln(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        // invalid numRows
        if(numRows == 0) return triangle;
        
        // first row is always 1
        List<Integer> first_row = new ArrayList<Integer>();
        first_row.add(1);
        triangle.add(first_row);
        
        // start from the second row
        for(int i=1; i<numRows; i++) {
            // we need to sum elements from the prev row
            List<Integer> prev = triangle.get(i-1);
            List<Integer> curr = new ArrayList<Integer>();
            // first element of every row is 1
            curr.add(1);
            
            // for i=2
            // current row has i+1 elements -> 3rd row, index 2 -> 3 elements
            // previous row has i elements -> 2nd row, index 1 -> 2 elements
            // iterate through the previous row and add adjacent elements
            for(int j=1; j<i; j++)
                curr.add(prev.get(j-1) + prev.get(j));
            
            // last element of each row is 1
            curr.add(1);
            triangle.add(curr);
        }
        
        return triangle;
    }
    
    void initialiseTriangle(List<List<Integer>> result) {
        List<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        result.add(row1);
        List<Integer> row2 = new ArrayList<Integer>();
        row2.add(1);
        row2.add(1);
        result.add(row2);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        switch(numRows) {
            case 0:
                return result;
            case 1:
                List<Integer> row1 = new ArrayList<Integer>();
                row1.add(1);
                result.add(row1);
                return result;
            case 2:
                initialiseTriangle(result);
                return result;
        }

        if(numRows > 2) {
        initialiseTriangle(result);
        for(int i=2; i<numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            
            List<Integer> prev = result.get(i-1);
            
            for(int j=1; j<= i-1; j++) {
                list.add(prev.get(j-1) + prev.get(j));
            }
            list.add(1);
            result.add(list);
        }
        }
        return result;
    }
}