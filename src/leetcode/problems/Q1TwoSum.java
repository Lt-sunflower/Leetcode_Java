package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1TwoSum implements Problem{

    /**
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     * **/

    private int[] nums;
    private int target;

    public Q1TwoSum() {
        this.nums = new int[] {3, 2, 4};
        this.target = 6;
    }


    public Q1TwoSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public int[] solve() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])) return (new int[] {map.get(nums[i]), i});
            else map.put(target-nums[i],i);
        }
        return null;
    }


    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + Arrays.toString(nums) + ", " + target);
        System.out.println("Answer: " + Arrays.toString(solve()));
    }
}
