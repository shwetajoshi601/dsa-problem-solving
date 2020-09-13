class ArrMajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        // for majority element occuring more than n/3 times, there can be at the most 2 majority elements
        List<Integer> res = new ArrayList<Integer>();
        
        // use Boyer-Moore's Voting Algorithm
        // two counters and two candidates
        int cand1=0,cand2=0,count1=0,count2=0;
        
        // same intuition as majority element I
        for(int n: nums) {
            // note that you first check if the cand equals the current element and then check if counts are 0
            if(cand1==n) {
                count1++;
            } else if(cand2==n) {
                count2++;
            } else if(count1==0) {
                cand1=n;
                count1=1;
            } else if(count2==0) {
                cand2=n;
                count2=1;
            } else {
                count1--;
                count2--;
            }
        }
        
        System.out.println("cand1: " + cand1 + ", cand2: " + cand2);
        
        // we only get 2 candidates
        // it can be possible that there is no majority element
        count1=0;
        count2=0;
        
        // check how many times cand1 and cand2 occur
        for(int n: nums) {
            if(n==cand1)
                count1++;
            else if(n==cand2)
                count2++;
        }
        
        // if they occur more than n/3 times, add them to the result
        if(count1>nums.length/3)
            res.add(cand1);
        
        if(count2 > nums.length/3)
            res.add(cand2);
        
        return res;
    }
}