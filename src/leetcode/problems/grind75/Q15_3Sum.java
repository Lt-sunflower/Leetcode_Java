package leetcode.problems.grind75;

import leetcode.problems.Problem;

import java.util.*;

public class Q15_3Sum implements Problem {

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     **/

    private int[] nums;

    public Q15_3Sum(){
        this.nums = new int[] {-1,0,1,2,-1,-4};
    }

    private List<List<Integer>> solve(){

        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length-2; i++){

            // if index i > 0, search complete. (sum of 3 +ve numbers cannot be 0)
            if (nums[i] > 0) break;

            // if i is same val, skip
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i+1;
            int k = nums.length-1;
            while(k>j){
                if (nums[i] + nums[j] + nums[k] == 0) {
                    set.add(List.of(nums[i], nums[j], nums[k]));

                    // if j or k is same val, skip
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;}
                else if (nums[i] + nums[j] + nums[k] > 0) k--;
                else j++;
            }

        }

        return new ArrayList<>(set);
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + Arrays.toString(nums));
        System.out.println("Answer: " + solve());
    }
}
