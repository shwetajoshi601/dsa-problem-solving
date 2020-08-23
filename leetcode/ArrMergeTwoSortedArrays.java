class ArrMergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // start from end since the elements need to be written to nums1
        // just to avoid overwriting elements
        // if creating an array of size m+n was allowed, you could start from the beginning
        
        // i->nums1, j->nums2, curr->current position to fill in nums1
        int i=m-1, j=n-1, curr=m+n-1;
        
        while(i>=0 && j >=0) {
            // if nums1 has an element > than the element in nums2
            if(nums1[i] >= nums2[j])
                // fill the position with nums1 element
                nums1[curr--] = nums1[i--];
            else
                // nums2 has a greater element, fill the position with nums2 element
                nums1[curr--] = nums2[j--];
        }
        
        // fill remaining elements from nums2 if size of nums2 is greater than size of nums1
        while(j >= 0) {
            nums1[curr--] = nums2[j--];
        }
        
        // note that a loop for nums1 is not required since it would already contain the remaining elements and the array is already sorted
    }
}