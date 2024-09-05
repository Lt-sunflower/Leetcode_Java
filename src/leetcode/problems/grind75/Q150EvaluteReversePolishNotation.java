package leetcode.problems.grind75;

import leetcode.problems.Problem;

import java.util.Arrays;
import java.util.Stack;

public class Q150EvaluteReversePolishNotation implements Problem {

    /**
     * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
     * Evaluate the expression. Return an integer that represents the value of the expression.
     **/

    private String[] tokens;

    public Q150EvaluteReversePolishNotation(){
        this.tokens = new String[]{"2","1","+","3","*"};
    }

    private int solve(){
        Stack<Integer> stack = new Stack<>();

        for(String s:tokens){
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) stack.add(Integer.valueOf(s));
            else {
                if (s.equals("+")){
                    int inta = stack.pop();
                    int intb = stack.pop();
                    stack.push(inta+intb);

                } else if (s.equals("-")){
                    int inta = stack.pop();
                    int intb = stack.pop();
                    stack.push(intb-inta);

                } else if (s.equals("*")){
                    int inta = stack.pop();
                    int intb = stack.pop();
                    stack.push(inta*intb);

                } else if (s.equals("/")){
                    int inta = stack.pop();
                    int intb = stack.pop();
                    stack.push(intb/inta);
                }
            }
        }
        return stack.pop();
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + Arrays.toString(tokens));
        System.out.println("Answer: " + solve());
    }
}
