package leetcode.problems.grind75;

import leetcode.problems.Problem;

public class Q125ValidPalindrome implements Problem {

    /**
     * Given a string s, return true if it is a palindrome, or false otherwise.
     **/

    private String s;

    public Q125ValidPalindrome() {
        this.s = "A man, a plan, a canal: Panama";
    }

    public Q125ValidPalindrome(String s) {
        this.s = s;
    }

    private boolean solve() {

        // remove special char
        s = s.replaceAll("{^a-zA-Z0-9}", "");

        // ignore case
        s = s.toLowerCase();

        int n = 0;
        int m = s.length()-1;

        while (m>n) {
            if (s.charAt(m) != s.charAt(n)) return false;
            else n++; m--;
        }
        return true;
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + s);
        System.out.println("Answer: " + solve());
    }
}
