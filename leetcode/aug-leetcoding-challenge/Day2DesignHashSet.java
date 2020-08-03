class Day2DesignHashSet {

    List<List<Integer>> buckets;
    // range of elements specified
    static int MAX_LIMIT = 1000000;
    
    /** Initialize your data structure here. */
    public Day2DesignHashSet() {
        // initialize a list with max number of buckets
        buckets = new ArrayList<List<Integer>>(MAX_LIMIT);
        System.out.println(buckets.size());
        // each bucket can contain max limit elements
        for(int i=0; i< MAX_LIMIT; i++) {
            buckets.add(new ArrayList<Integer>());
        }
    }
    
    // hash function
    int hash(int key) {
        return (key % MAX_LIMIT);
    }
    
    public void add(int key) {
        // get the bucket index
        int bucketIndex = hash(key);
        // get the bucket
        List<Integer> elems = buckets.get(bucketIndex);
        // if the element is not already present, add it -this gives the set property
        if(!elems.contains(key))
            elems.add(key);
    }
    
    public void remove(int key) {
        // similar logic, get the bucket, remove the element if it exists
        int bucketIndex = hash(key);
        List<Integer> elems = buckets.get(bucketIndex);
        if(elems.contains(key))
        // new Integer() creates wraps the value in an object which makes it possible to remove by value
        // if an object is not passed to remove, the argument is considered as an index
            elems.remove(new Integer(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = hash(key);
        List<Integer> elems = buckets.get(bucketIndex);
        if(elems.contains(key))
            return true;
        
         return false;
    }
}

/**
 * Your Day2DesignHashSet object will be instantiated and called as such:
 * Day2DesignHashSet obj = new Day2DesignHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */