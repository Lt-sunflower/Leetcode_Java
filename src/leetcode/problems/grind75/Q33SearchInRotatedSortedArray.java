package leetcode.problems.grind75;

import leetcode.problems.Problem;

import java.util.Arrays;

public class Q33SearchInRotatedSortedArray implements Problem {

    /**
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
     * (1 <= k < nums.length) such that the resulting array is
     * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1],..., nums[k-1]] (0-indexed).
     * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     **/

    private int[] nums;
    private int target;

    public Q33SearchInRotatedSortedArray(){
        this.nums = new int[] {4,5,6,7,0,1,2};
        this.target = 2;
    }

    private int solve(){

        int start = 0;
        int end = nums.length-1;

        while(end>=start){

            int mid = start + (end-start)/2;
            int midVal = nums[mid];

            if (nums[mid] == target) return mid;

            // only sorted can indicate [low,..,high]
            if (nums[start] <= midVal) { // Left part is sorted
                if (nums[start] <= target && target < midVal) {
                    end = mid - 1; // Target is in the left part
                } else {
                    start = mid + 1; // Target is in the right part
                }
            } else { // Right part is sorted
                if (midVal < target && target <= nums[end]) {
                    start = mid + 1; // Target is in the right part
                } else {
                    end = mid - 1; // Target is in the left part
                }
            }
        }
        return -1;
    }

    private int solve(boolean b){
        if(nums==null || nums.length==0) return -1;

        int l=0, r=nums.length-1, m=0;
        // find out the index of the smallest element.
        while(l<r){
            m = (l+r)/2;
            if(nums[m] > nums[r]){
                l = m+1;
            }else{
                r = m;
            }
        }

        // [4,5,6,7,0,1,2]
        // use smallest value to form [4,5,6,7] and [0,1,2]
        int s = l;
        l = 0; r = nums.length-1;
        if(target >= nums[s] && target <= nums[r]){
            l = s;
        }else{
            r = s;
        }

        // perform normal binary search on smaller sorted array
        while(l<=r){
            m = (l+r)/2;
            if(nums[m]==target) return m;
            else if(nums[m] > target) r = m-1;
            else l=m+1;
        }

        return -1;
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + Arrays.toString(nums));
        System.out.println("Answer: " + solve(true));
    }
}
