package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Q13RomanToInteger implements Problem{

		/**
		 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
		 * Symbol Value
		 *    I    1
		 *    V    5
		 *    X    10
		 *    L    50
		 *    C   100
		 *    D   500
		 *    M   1000
		 * Given a roman numeral, convert it to an integer.
		 **/

		private String s;

		public Q13RomanToInteger(){
				this.s = "MCMXCIV";
		}

		public int solve(){

				Map<Character, Integer> m = new HashMap<>();
				m.put('I', 1);
				m.put('V', 5);
				m.put('X', 10);
				m.put('L', 50);
				m.put('C', 100);
				m.put('D', 500);
				m.put('M', 1000);

				int ans = 0;
				int prev = 0;

				// traverse backwards to avoid doing double/out-of-bounds
				for (int i=s.length()-1; i>=0; i--){
						char c = s.charAt(i);
						int curr = m.get(c);

						if (curr >= prev) {
								ans += curr;
						} else {
								ans -= curr;
						}
						prev = curr;
				}

				return ans;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + s);
				System.out.println("Answer: " + solve());
		}
}
