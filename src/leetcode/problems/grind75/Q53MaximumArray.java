package leetcode.problems.grind75;

import java.util.Arrays;
import leetcode.problems.Problem;

public class Q53MaximumArray implements Problem {

		/**
		 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
		 **/

		private int[] nums;

		public Q53MaximumArray(){
				this.nums = new int[] {-2, -5, 6, -2, -3, 1, 5, -6};
		}

		private int solve(){
				int largestSum=Integer.MIN_VALUE;
				int currentSum=0;

				for (int i=0; i<nums.length; i++){
						if (currentSum < 0) currentSum = 0;

						currentSum+=nums[i];
						if (currentSum > largestSum) largestSum = currentSum;
				}
				return largestSum;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + Arrays.toString(nums));
				System.out.println("Answer: " + solve());
		}
}
