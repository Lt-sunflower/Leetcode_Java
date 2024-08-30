package leetcode.problems.grind75;

import java.util.Arrays;
import java.util.List;
import leetcode.models.ListNode;
import leetcode.problems.Problem;
import leetcode.utils.ListNodeUtils;

public class Q206ReverseLinkedList implements Problem {

		private ListNode head;

		public Q206ReverseLinkedList(){
				this.head = ListNodeUtils.createList(Arrays.asList(1,2,3,4,5));
		}
		public Q206ReverseLinkedList(ListNode head){
				this.head = head;
		}

		private ListNode solve() {

				ListNode newHead = null;

				while(head != null){
						ListNode next = head.next;
						head.next = newHead;
						newHead = head;
						head = next;
				}
				return newHead;

				// iter1 (2chains): 1->null, 2->3->4->5
				// iter2: new 2->1->null, old 3->4->5
		}

		@Override
		public void printAnswer() {
				ListNodeUtils.printList(head, "Inputs: ");
				ListNodeUtils.printList(solve(), "Answer: ");

		}
}
