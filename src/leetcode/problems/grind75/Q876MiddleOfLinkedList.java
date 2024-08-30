package leetcode.problems.grind75;

import java.util.Arrays;
import leetcode.models.ListNode;
import leetcode.problems.Problem;
import leetcode.utils.ListNodeUtils;

public class Q876MiddleOfLinkedList implements Problem {

		/**
		 * Given the head of a singly linked list, return the middle node of the linked list.
		 * If there are two middle nodes, return the second middle node.
		 **/

		private ListNode head;

		public Q876MiddleOfLinkedList(){
				this.head = ListNodeUtils.createList(Arrays.asList(1,2,3,4,5));
		}

		private ListNode solve() {
				ListNode slow = head;
				ListNode fast = head;

				while(fast != null && fast.next != null){
						slow=slow.next;
						fast=fast.next.next;
				}

				return slow;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + ListNodeUtils.printListAsArray(head,""));
				System.out.println("Inputs: " + ListNodeUtils.printListAsArray(solve(),""));

		}

}
