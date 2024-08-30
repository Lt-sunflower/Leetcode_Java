package leetcode.problems.grind75;

import java.util.Arrays;
import leetcode.models.TreeNode;
import leetcode.problems.Problem;
import leetcode.utils.TreeNodeUtils;

public class Q104MaximumDepthOfBinaryTree implements Problem {

		/**
		 * Given the root of a binary tree, return its maximum depth.
		 *
		 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
		 **/

		private TreeNode root;

		public Q104MaximumDepthOfBinaryTree(){
				this.root = TreeNodeUtils.createTree(Arrays.asList(3,9,20,null,null,15,7));
		}

		private int solve(){
				return maxDepth(root,1);
		}

		private int maxDepth(TreeNode root, int i) {
				if (root == null) return i-1;

				int right = maxDepth(root.right,i+1);
				int left = maxDepth(root.left, i+1);

				return Math.max(left, right);
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + TreeNodeUtils.printTreeAsArray(root,""));
				System.out.println("Answer: " + solve());
		}
}
