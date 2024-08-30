package leetcode.problems.grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import leetcode.problems.Problem;

public class Q232ImplementQueueUsingStacks implements Problem {

		/**
		 * Implement a first in first out (FIFO) queue using only two stacks.
		 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
		 **/

		private List<String> actions;
		private List<Integer> values;

		public Q232ImplementQueueUsingStacks() {
//				this.actions = List.of("MyQueue","push","push","peek","pop","empty");
//				this.values = new ArrayList<>(Arrays.asList(null, 1, 2, null, null, null));

				this.actions = List.of("MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop");
				this.values = new ArrayList<>(Arrays.asList(null, 1, 2, 3, 4, null, 4, null, null, null, null));
		}

		public class MyQueue {

				public Stack<Integer> in_stack;
				public Stack<Integer> out_stack;
				public MyQueue() {
						in_stack = new Stack<>();
						out_stack = new Stack<>();
				}

				public void push(int x) {
						in_stack.push(x);
				}

				public int pop() {
						if(out_stack.empty()) {
								while(!in_stack.empty()) {
										out_stack.push(in_stack.pop());
								}
						}
						return out_stack.pop();
				}

				public int peek() {
						if(out_stack.empty()) {
								while(!in_stack.empty()) {
										out_stack.push(in_stack.pop());
								}
						}
						return out_stack.peek();
				}

				public boolean empty() {
						return (in_stack.empty() && out_stack.empty());
				}
		}

		private String reason;
		private boolean verify() {

				MyQueue myQueue = new MyQueue();
				Queue<Integer> actualQueue = new LinkedList<>();

				if (actions.size() != values.size()) {
						reason = "Inputs of different sizes.";
						return false;
				}

				for (int i=0; i< actions.size(); i++) {
						switch (actions.get(i)) {
								case "MyQueue":
										break;
								case "push":
										myQueue.push(values.get(i));
										actualQueue.add(values.get(i));
										break;
								case "pop":
										int test = myQueue.pop();
										int actual = actualQueue.poll();
										if (test != actual){
												reason = "index " + i + ", myqueue pop = " + test + " correct pop = " + actual;
												return false;
										}
										break;
								case "peek":
										test = myQueue.peek();
										actual = actualQueue.peek();
										if (test != actual){
												reason = "index " + i + ", myqueue peek = " + test + " correct peek = " + actual;
												return false;
										}
										break;
								case "empty":
										boolean testEmpty = myQueue.empty();
										boolean actualEmpty = actualQueue.isEmpty();
										if (testEmpty != actualEmpty){
												reason = "index " + i + ", myqueue empty = " + testEmpty + " correct empty = " + actualEmpty;
												return false;
										}
										break;
								default:
										reason = "index " + i + ", action " + actions.get(i) + " not found";
										return false;
						}
				}
				return true;
		}

		@Override
		public void printAnswer() {
				boolean verified = verify();
				System.out.println("Verify by comparing with queue: " + verified);
				if (!verified) {
						System.out.println("Reason for failure: " + reason);
				}
		}
}
