package leetcode.problems;

import java.util.Arrays;

public class Q704BinarySearch implements Problem {

    /**
     * Given an array of integers nums which is sorted in ascending order, and an integer target,
     * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
     * You must write an algorithm with O(log n) runtime complexity.
     **/

    private int[] nums;
    private int target;

    public Q704BinarySearch() {
        this.nums = new int[] {-1,0,3,5,9,12};
        this.target = 9;
    }

    public Q704BinarySearch(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public int solve() {
        int start = 0;
        int end = nums.length-1;

        while (end>=start) {
            int mid = (end+start)/2;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + Arrays.toString(nums) + ", " + target);
        System.out.println("Answer: " + solve());
    }
}
