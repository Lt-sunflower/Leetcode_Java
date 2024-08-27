package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Q383RansomNote implements Problem{

		/**
		 * Given two strings ransomNote and magazine,
		 * return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
		 *
		 * Each letter in magazine can only be used once in ransomNote.
		 **/

		private String ransomNote;
		private String magazine;

		public Q383RansomNote() {
				this.ransomNote = "a";
				this.magazine = "b";
		}

		public Q383RansomNote(String ransomNote, String magazine) {
				this.ransomNote = ransomNote;
				this.magazine = magazine;
		}

		public boolean solve(){

				Map<Character, Integer> map = new HashMap<>();

				for(Character c : magazine.toCharArray()){
						if (!map.containsKey(c)){
								map.put(c,1);
						} else {
								map.put(c, map.get(c)+1);
						}
				}

				for(Character c : ransomNote.toCharArray()){
						if (map.containsKey(c)){
								if (map.get(c) > 0)
									map.put(c, map.get(c)-1);
								else return false;
						} else {
								return false;
						}
				}

				return true;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: ransomNote=" + ransomNote + ", magazine=" + magazine);
				System.out.println("Answer: " + solve());
		}
}
