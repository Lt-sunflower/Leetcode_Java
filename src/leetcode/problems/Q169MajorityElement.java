package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q169MajorityElement implements Problem{

		/**
		 * Given an array nums of size n, return the majority element.
		 *
		 * The majority element is the element that appears more than ⌊n / 2⌋ times.
		 * You may assume that the majority element always exists in the array.
		 **/

		private final int[] nums;

		public Q169MajorityElement() {
				this.nums = new int[] {2,2,1,1,1,2,2};
		}

		public Q169MajorityElement(int[] nums) {
				this.nums = nums;
		}

		private int solve(){
				if (nums.length==1) return nums[0];

				int majorityCount = nums.length/2;

				Map<Integer, Integer> map = new HashMap<>();
				for (int i:nums){
						if (map.containsKey(i)){
								if(map.get(i)>=majorityCount) return i;
								else map.put(i,map.get(i)+1);
						}
						else map.put(i,1);
				}
				return -1;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + Arrays.toString(nums));
				System.out.println("Answer: " + solve());
		}
}
