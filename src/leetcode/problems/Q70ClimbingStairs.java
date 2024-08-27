package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Q70ClimbingStairs implements Problem{

		private int n;

		public Q70ClimbingStairs() {
				this.n = 5;
		}

		public Q70ClimbingStairs(int n) {
				this.n = n;
		}

		private int solve(){
//				return climbStairs(n);

				/**
				 *                         (0)
				 *                        /   \
				 *                       +1   +2
				 *                      /      \
				 *                    (1)      (2)
				 *                   /   \     /  \
				 *                 +1    +2  +1   +2
				 *                 /      \  /      \
				 *               (2)     (3)(3)     (4)
				 *              /  \    /   /
				 *            +1   +2 +1  +1
				 *            /     \ /   /
				 *          (3)    (4)(4)(4)
				 *          /
				 *         +1
				 *        /
				 *      (4)
				 *      Observations:
				 *      fibonacci, climb(1)=1, (2)=2, (3)=3, (4)=5, (5)=8, ...
				 *      return 2 when (2), return 1 when (3). Avoid redundant calc.
				 */

				Map<Integer, Integer> memo = new HashMap<>();
				return climbStairs(n, memo);
		}

		private int climbStairs(int n, Map<Integer, Integer> memo) {
				if (n == 0 || n == 1) {
						return 1;
				}
				if (!memo.containsKey(n)) {
						memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
				}
				return memo.get(n);
		}

		private int climbStairs(int n) {
				if (n==0 || n==1) return 1;
				return climbStairs(n-1) + climbStairs(n-2);
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + n);
				System.out.println("Answer: " + solve());
		}
}
