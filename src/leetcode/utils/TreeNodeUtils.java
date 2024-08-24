package leetcode.utils;

import leetcode.models.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtils {

    public static TreeNode createTree(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(values.getFirst());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (index < values.size()) {
            TreeNode current = queue.poll();

            if (values.get(index) != null) {
                current.left = new TreeNode(values.get(index));
                queue.add(current.left);
            }
            index++;

            if (index >= values.size()) break;

            if (values.get(index) != null) {
                current.right = new TreeNode(values.get(index));
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    public static void printTree(TreeNode node, String s){
        if (node == null) {
            System.out.println(s + "[]");
            return;
        }

        List<Integer> values = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                values.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            } else {
                values.add(null); // Add null for missing children if needed
            }
        }

        // Remove trailing nulls (they are not needed for compact representation)
        while (!values.isEmpty() && values.getLast() == null) {
            values.removeLast();
        }

        // Convert the list to a string representation
        System.out.println(s + values.toString());
    }

    public static String printTreeAsArray(TreeNode node, String s){
        if (node == null) {
            return (s + "[]");
        }

        List<Integer> values = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                values.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            } else {
                values.add(null); // Add null for missing children if needed
            }
        }

        // Remove trailing nulls (they are not needed for compact representation)
        while (!values.isEmpty() && values.getLast() == null) {
            values.removeLast();
        }

        // Convert the list to a string representation
        return (s!=null)?s + values.toString(): values.toString();
    }
}
