package leetcode.problems.grind75;

import leetcode.problems.Problem;

public class Q67AddBinary implements Problem {

		/**
		 * Given two binary strings a and b, return their sum as a binary string.
		 **/

		private String a;
		private String b;

		public Q67AddBinary(){
				this.a = "1010";
				this.b = "1011";
		}

		public Q67AddBinary(String a, String b){
				this.a = a;
				this.b = b;
		}

		private String solve(){
				int carry = 0;
				int aLength = a.length()-1;
				int bLength = b.length()-1;
				StringBuilder sb = new StringBuilder();

				while(aLength>=0 || bLength>=0 || carry==1){
						if (aLength>=0){
								carry += Character.getNumericValue(a.charAt(aLength));
								aLength-=1;
						}
						if (bLength>=0){
								carry += Character.getNumericValue(b.charAt(bLength));
								bLength-=1;
						}
						sb.append(carry % 2);
						carry /= 2;
				}
				return sb.reverse().toString();

		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: a=" + a + ", b=" + b);
				System.out.println("Answer: " + solve());
		}
}
