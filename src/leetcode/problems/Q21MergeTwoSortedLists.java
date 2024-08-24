package leetcode.problems;

import leetcode.models.ListNode;
import leetcode.utils.ListNodeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q21MergeTwoSortedLists implements Problem {

    /**
     * Given 2 sorted lists, merge the two lists into one sorted list.
     * The list should be made by splicing together the nodes of the first two lists.
     * **/

    private ListNode list1;
    private ListNode list2;

    public Q21MergeTwoSortedLists() {
        this.list1 = ListNodeUtils.createList(List.of(1,2,4));
        this.list2 = ListNodeUtils.createList(List.of(1,3,4));
    }

    public Q21MergeTwoSortedLists(ListNode list1, ListNode list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public Q21MergeTwoSortedLists(List<Integer> list1, List<Integer> list2) {
        this.list1 = ListNodeUtils.createList(list1);
        this.list2 = ListNodeUtils.createList(list1);
    }

    public Q21MergeTwoSortedLists(int[] list1, int[] list2) {
        this.list1 = ListNodeUtils.createList(Arrays.stream(list1)
                .boxed() // Convert int to Integer
                .collect(Collectors.toList()));
        this.list2 = ListNodeUtils.createList(Arrays.stream(list2)
                .boxed() // Convert int to Integer
                .collect(Collectors.toList()));
    }

    private ListNode solve() {

        ListNode list3 = new ListNode();
        ListNode cur = list3;
        while( list1 != null & list2 != null)
        {
            if (list1.val < list2.val){
                ListNode n = new ListNode(list1.val);
                cur.next = n;
                cur = cur.next;
                list1 = list1.next;
            }
            else {
                ListNode n = new ListNode(list2.val);
                cur.next = n;
                cur = cur.next;
                list2 = list2.next;
            }
        }

        while(list1 != null) {
            cur.next = new ListNode(list1.val);
            cur = cur.next;
            list1 = list1.next;
        }
        while(list2 != null) {
            cur.next = new ListNode(list2.val);
            cur = cur.next;
            list2 = list2.next;
        }

        return list3.next;
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + ListNodeUtils.printListAsArray(list1,null) + ", " + ListNodeUtils.printListAsArray(list2,null));
        ListNodeUtils.printList(solve(), "Answer: ");
    }

}
