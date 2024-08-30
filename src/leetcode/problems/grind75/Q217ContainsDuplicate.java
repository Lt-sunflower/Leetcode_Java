package leetcode.problems.grind75;

import java.util.Arrays;
import leetcode.problems.Problem;

public class Q217ContainsDuplicate implements Problem {

		private int[] nums;

		public Q217ContainsDuplicate() {
				this.nums = new int[] {1,2,3,1};
		}

		private boolean solve(){
				Arrays.sort(nums);
				for (int i=1; i<nums.length; i++){
						if (nums[i] == nums[i-1]) return true;
				}
				return false;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + Arrays.toString(nums));
				System.out.println("Answer: " + solve());
		}
}
