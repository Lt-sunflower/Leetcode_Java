package leetcode.problems.grind75;

import leetcode.models.TreeNode;
import leetcode.problems.Problem;
import leetcode.utils.TreeNodeUtils;

import java.util.*;

public class Q102BinaryTreeLevelOrderTraversal implements Problem {

    /**
     * Given the root of a binary tree, return the level order traversal of its nodes' values.
     * (i.e., from left to right, level by level).
     **/

    private TreeNode root;

    public Q102BinaryTreeLevelOrderTraversal(){
        this.root = TreeNodeUtils.createTree(Arrays.asList(3,9,20,null,null,15,7));
    }

    private List<List<Integer>> solve(){

        Queue<TreeNode> queue= new LinkedList<TreeNode>();

        List<List<Integer>> result= new ArrayList<>();
        if(root == null) return result;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode n = queue.poll();
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
                temp.add(n.val);
            }
            result.add(temp);
        }
        return result;
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + TreeNodeUtils.printTreeAsArray(root,""));
        System.out.println("Answer: " + solve());
    }
}
