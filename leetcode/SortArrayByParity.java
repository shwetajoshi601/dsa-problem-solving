class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        
        for(int i=0; i<A.length; i++) {
            if(A[i] % 2 == 0)
                even.add(A[i]);
            else 
                odd.add(A[i]);
        }
        // join the even list followed by odd list
        even.addAll(odd);
        
        // convert Integer list to int array
        Iterator<Integer> itr = even.iterator();
        for(int i=0; i< A.length; i++) {
            A[i] = itr.next().intValue();
        }
        return A;
    }
}