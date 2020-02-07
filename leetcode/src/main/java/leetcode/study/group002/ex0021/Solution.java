package leetcode.study.group002.ex0021;

/**
 * @Author : josan
 * @Date : 2020/2/6 16:34
 * @Package : leetcode.study.group002.ex0021
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpHead1 = new ListNode(-1);
        dumpHead1.next = l1;
        ListNode dumpHead2 = new ListNode(-1);
        dumpHead2.next = l2;

        return mergeTwoSortedLists(dumpHead1, dumpHead2);
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1.next;
        ListNode p2 = l2.next;

        ListNode head = l1;
        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}