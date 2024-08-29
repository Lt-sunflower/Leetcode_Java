package leetcode.problems;

import leetcode.models.TreeNode;
import leetcode.utils.TreeNodeUtils;

import java.util.Arrays;

public class Q543DiameterOfBinaryTree implements Problem{

    private TreeNode root;

    public Q543DiameterOfBinaryTree(){
        this.root = TreeNodeUtils.createTree(Arrays.asList(4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2));
    }
    public Q543DiameterOfBinaryTree(TreeNode root){
        this.root = root;
    }

    private int diameter=0;
    private int solve(){

        calculate(root); // calculate returns height
        return diameter; // diameter is longest route
    }

    private int calculate(TreeNode n){
        if (n == null) return 0;

        int right = calculate(n.right);
        int left = calculate(n.left);

        diameter = Math.max(left+right, diameter); // if not, will only count through root

        return Math.max(left, right) +1;
    }

    @Override
    public void printAnswer() {
        TreeNodeUtils.printTree(root, "Inputs: ");
        System.out.println("Answer: " + solve());
    }
}
