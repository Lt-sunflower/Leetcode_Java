package leetcode.problems;

public class Q9PalindromeNumber implements Problem{

		/**
		 * Given an integer x, return true if x is a palindrome, and false otherwise.
		 **/

		private int x;

		public Q9PalindromeNumber() {
				this.x = 121;
		}

		private boolean solve(){
//				String s = String.valueOf(x);
//
//				int front = 0;
//				int back = s.length()-1;
//				while (back >= front){
//						if (s.charAt(front) != s.charAt(back)) return false;
//						front++;
//						back--;
//				}
//				return true;

				// attempt without converting to string. can eliminate -ve numbers first too.
				int reversed = 0;
				int temp = x;
				while (temp>0){
						int curr = temp%10;
						reversed = reversed*10+curr;
						temp = temp/10;
				}
				return reversed == x;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + x);
				System.out.println("Answer: " + solve());
		}
}
