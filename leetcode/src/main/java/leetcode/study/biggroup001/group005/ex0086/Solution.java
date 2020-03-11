package leetcode.study.biggroup001.group005.ex0086;

import leetcode.study.common.ListNode;

/**
 * @Author : josan
 * @Date : 2020/3/4 0:19
 * @Package : leetcode.study.group005.ex0086
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        head = dumpHead;

        return partitionInner(head, x);
    }

    private ListNode partitionInner(ListNode head, int x) {
        ListNode largeHead = new ListNode(-1);

        ListNode prev = head;
        ListNode p = head.next;
        ListNode q = largeHead;

        while (p != null) {
            if (p.val < x) {
                prev.next = p;
                prev = prev.next;
                p = p.next;
                prev.next = null;
            } else {
                q.next = p;
                q = q.next;
                p = p.next;
                q.next = null;
            }
        }
        prev.next = largeHead.next;

        return head.next;
    }
}
