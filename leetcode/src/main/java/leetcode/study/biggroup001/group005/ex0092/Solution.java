package leetcode.study.biggroup001.group005.ex0092;

import leetcode.study.common.ListNode;

/**
 * @Author : josan
 * @Date : 2020/3/7 13:05
 * @Package : leetcode.study.group005.ex0092
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        head = dumpHead;
        ListNode p = head.next;
        int len = 0;
        while (p != null) {
            p = p.next;
            ++len;
        }
        if (m < 1 || n < m || len < n) {
            throw new IllegalArgumentException("head, m, n is wrong");
        }

        return reverseBetweenInner(head, m, n);
    }

    private ListNode reverseBetweenInner(ListNode head, int m, int n) {
        ListNode p = head;

        int i = 0;
        while (p != null && i != (m - 1)) {
            p = p.next;
            ++i;
        }
        ListNode pm1 = p;

        while (p != null && i != n) {
            p = p.next;
            ++i;
        }
        ListNode pn = p;
        ListNode pn1 = pn.next;
        pn.next = null;
        ListNode pm = pm1.next;
        reverse(pm);
        pm1.next = pn;
        pm.next = pn1;

        return head.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode dumpHead = new ListNode(-1);
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = dumpHead.next;
            dumpHead.next = p;
            p = next;
        }
        return dumpHead.next;
    }
}
