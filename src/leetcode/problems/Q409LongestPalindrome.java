package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Q409LongestPalindrome implements Problem{

		/**
		 * Given a string s which consists of lowercase or uppercase letters,
		 * return the length of the longest palindrome that can be built with those letters.
		 *
		 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
		 **/

		private String s;

		public Q409LongestPalindrome(){
				this.s = "abccccdd";
		}

		private int solve(){

				// for each alphabet, if divisible by 2, ans+=2
				// once all alphabets not divisible by 2, if any alphabets left, ans+=1

				Map<Character, Integer> map = new HashMap<>();
				int ans = 0;
				for (Character c : s.toCharArray()){
						if (map.containsKey(c)) map.put(c,map.get(c)+1);
						else map.put(c,1);
				}
				for (Character c: map.keySet()) {
						int charCount = map.get(c);
						if (charCount > 1){
								if (charCount%2 ==1){
										ans+=charCount-1;
										map.put(c, 1);
								} else {
										ans+=charCount;
										map.put(c,0);
								}
						}
				}
				for (Character c: map.keySet()) {
						int charCount = map.get(c);
						if (charCount > 0){
							ans+=1;
							return ans;
						}
				}
				return ans;

		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + s);
				System.out.println("Answer: " + solve());

		}
}
