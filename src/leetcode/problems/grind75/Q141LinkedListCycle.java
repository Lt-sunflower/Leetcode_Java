package leetcode.problems.grind75;

import java.util.ArrayList;
import java.util.Arrays;
import leetcode.models.ListNode;
import leetcode.problems.Problem;
import leetcode.utils.ListNodeUtils;

public class Q141LinkedListCycle implements Problem {

		/**
		 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
		 **/

		private ListNode head;
		private int pos = -1;

		public Q141LinkedListCycle() {
				pos = -1;
				this.head = ListNodeUtils.createList(new ArrayList<>(Arrays.asList(1,2)), pos);
		}

		public Q141LinkedListCycle(ListNode head, int pos) {
				this.pos = pos;
				this.head = ListNodeUtils.createList(new ArrayList<>(Arrays.asList(1,2)), pos);
		}

		public boolean solve() {

				ListNode slow = head;
				ListNode fast = head;

				while (fast != null && fast.next != null) {
						slow = slow.next;
						fast = fast.next.next;

						if (slow == fast) return true;
				}
				return false;
		}

		@Override
		public void printAnswer() {
				ListNodeUtils.printList(head, "Inputs: ");
				System.out.println("Answer: " + solve());
		}
}
