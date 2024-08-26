package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import leetcode.models.TreeNode;
import leetcode.utils.TreeNodeUtils;

public class Q110BalancedBinaryTree implements Problem {

		/**
		 * Given a binary tree, determine if it is height-balanced.
		 * A height-balanced binary tree is a binary tree in which
		 * the depth of the two subtrees of every node never differs by more than one (eg. Left height 2, Right height >3)
		 **/

		TreeNode root;

		public Q110BalancedBinaryTree() {
				this.root = TreeNodeUtils.createTree(new ArrayList<>(Arrays.asList(1,2,2,3,3,null,null,4,4)));
		}

		public Q110BalancedBinaryTree(TreeNode root) {
				this.root = root;
		}

		boolean isTreeBalanced = true;
		private boolean solve() {

				isBalanced(root, 1);
				return isTreeBalanced;
		}

		private int isBalanced(TreeNode root, int i) {

				if (root == null) return i-1;

				int right = (isBalanced(root.right, i+1));
				int left  = (isBalanced(root.left, i+1));

				if (Math.abs(left - right) > 1) isTreeBalanced=false;

				return Math.max(left, right);
		}

		@Override
		public void printAnswer() {
				TreeNodeUtils.printTree(root,"Inputs: ");
				System.out.println("Answer: " + solve());
		}

}
