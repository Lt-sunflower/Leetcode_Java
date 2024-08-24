package leetcode;

import leetcode.problems.*;


public class main {

    public static void main(String[] args){

        Q226InvertBinaryTree problem = new Q226InvertBinaryTree(new int[] {1,3,4});
        problem.printAnswer();

        System.out.println("Problem: " + problem.getClass().getSimpleName());

    }
}
