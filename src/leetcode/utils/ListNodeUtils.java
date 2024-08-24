package leetcode.utils;

import leetcode.models.ListNode;

import java.util.List;

public class ListNodeUtils {

    public static ListNode createList(List<Integer> values) {

        if (values == null || values.isEmpty()) return new ListNode(0);

        ListNode head = new ListNode(values.getFirst());
        ListNode current = head;

        for (int i = 1; i < values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode node, String s) {
        if (node == null) {
            System.out.println("null");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (s != null) sb.append(s);
        ListNode current = node;

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }

        System.out.println(sb.toString());
    }

    public static String printListAsArray(ListNode node, String s) {
        if (node == null) {
            return ("[]");
        }

        StringBuilder sb = new StringBuilder();
        if (s != null) sb.append(s);
        sb.append("[");
        ListNode current = node;

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return (sb.toString());
    }

}
