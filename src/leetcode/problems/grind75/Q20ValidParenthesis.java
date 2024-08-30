package leetcode.problems.grind75;

import java.util.Stack;
import leetcode.problems.Problem;

public class Q20ValidParenthesis implements Problem {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '{' and '}',
     * determine if the input string is valid.
     * **/

    private String s;

    public Q20ValidParenthesis() {
        this.s = "({})";
    }

    public Q20ValidParenthesis(String s) {
        this.s = s;
    }

    public boolean solve() {

        if (s.length() == 0) return true;
        if (s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                Character verify = stack.peek();
                if (s.charAt(i) == ')' & verify == '(') stack.pop();
                else if (s.charAt(i) == '}' & verify == '{') stack.pop();
                else if (s.charAt(i) == '}' & verify == '{') stack.pop();
                else return false;
            }
        }

        return (stack.isEmpty());
    }


    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + s);
        System.out.println("Answer: " + solve());
    }
}
