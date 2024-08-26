package leetcode.problems;

public class Q278FirstBadVersion implements Problem{

		/**
		 * Suppose you have n versions [1, 2, ..., n] and you want to find out
		 * the first bad one, which causes all the following ones to be bad.
		 *
		 * You are given an API bool isBadVersion(version) which returns whether version is bad.
		 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
		 **/

		private int n;
		private int bad;

		public Q278FirstBadVersion() {
				this.n = 1;
				this.bad = 1;
		}

		public Q278FirstBadVersion(int n, int bad) {
				this.n = n;
				this.bad = bad;
		}


		private int solve() {

				int btm = 1;
				int top = n;

				while (top > btm) {
						int mid = btm + (top-btm)/2;
						if (isBadVersion(mid)) top = mid;
						else btm = mid + 1;
				}

				return btm;
		}

		private boolean isBadVersion(int i) {
				return (i == bad);
		}

		@Override
		public void printAnswer() {
				System.out.println("Answer: " + solve());
		}
}
