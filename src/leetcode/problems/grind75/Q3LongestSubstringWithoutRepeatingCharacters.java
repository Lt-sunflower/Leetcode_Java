package leetcode.problems.grind75;

import leetcode.problems.Problem;

import java.util.HashSet;
import java.util.Set;

public class Q3LongestSubstringWithoutRepeatingCharacters implements Problem {

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     **/

    private String s;

    public Q3LongestSubstringWithoutRepeatingCharacters(){
        this.s = "pwwkew";
    }

    private int solve(){

        Set<Character> set = new HashSet<>();
        int longest=0;
        int l=0;
        int r=0;

        for (r=0; r<s.length(); r++){
            char c = s.charAt(r);
            // if duplicate, move left.
            if (set.contains(c)){
                while(set.contains(c)){
                    set.remove(s.charAt(l++));
                }
            } else {
                // set longest, +1 for distance.
                if (longest < r-l+1) {
                    longest = r-l+1;
                }
            }
            // add after, will need to add back after removing.
            set.add(c);
        }
        return longest;
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + s);
        System.out.println("Answer: " + solve());
    }
}
