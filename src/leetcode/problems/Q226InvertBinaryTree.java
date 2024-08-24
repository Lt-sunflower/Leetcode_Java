package leetcode.problems;

import leetcode.models.TreeNode;
import leetcode.utils.TreeNodeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q226InvertBinaryTree implements Problem{

    /**
     * Given the root of a binary tree, invert the tree, and return its root.
     **/

    private TreeNode root;

    public Q226InvertBinaryTree() {
        this.root = TreeNodeUtils.createTree(List.of(4,2,7,1,3,6,9));
    }

    public Q226InvertBinaryTree(TreeNode root) {
        this.root = root;
    }

    public Q226InvertBinaryTree(List<Integer> tree) { this.root = TreeNodeUtils.createTree(tree); }

    public Q226InvertBinaryTree(int[] tree) {
        this.root = TreeNodeUtils.createTree(Arrays.stream(tree)
            .boxed() // Convert int to Integer
            .collect(Collectors.toList())); }

    private TreeNode solve() {

        return invertTree(root);
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        else {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }

    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + TreeNodeUtils.printTreeAsArray(root,null));
        TreeNodeUtils.printTree(solve(), "Answer: ");
    }
}
