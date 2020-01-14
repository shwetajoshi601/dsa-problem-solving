class PascalsTriangle {
    
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