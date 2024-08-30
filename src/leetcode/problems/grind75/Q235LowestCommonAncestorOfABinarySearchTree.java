package leetcode.problems.grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import leetcode.models.TreeNode;
import leetcode.problems.Problem;
import leetcode.utils.TreeNodeUtils;

public class Q235LowestCommonAncestorOfABinarySearchTree implements Problem {

		/**
		 * 	Given a binary search tree (BST),
		 * 	find the lowest common ancestor (LCA) node of two given nodes in the BST.
		 **/

		private TreeNode root;
		private TreeNode p;
		private TreeNode q;

		public Q235LowestCommonAncestorOfABinarySearchTree() {
				List<Integer> list = new ArrayList<>(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));
				this.root = TreeNodeUtils.createTree(list);
				this.p = new TreeNode(2);
				this.q = new TreeNode(4);
		}

		public Q235LowestCommonAncestorOfABinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
				this.root = root;
				this.p = p;
				this.q = q;
		}

		private TreeNode solve() {

				return lowestCommonAncestor(root, p, q);
		}

		private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

				// base case?

				if (root.val > p.val && root.val > q.val)
						return lowestCommonAncestor(root.left, p , q);
				else if (root.val < p.val && root.val < q.val)
						return lowestCommonAncestor(root.right, p , q);
				else return root;
		}


		@Override
		public void printAnswer() {
				System.out.println("Answer: " + solve().val);
		}
}
