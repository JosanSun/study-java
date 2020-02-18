package leetcode.study.group004.ex0061;

import leetcode.study.common.ListNode;

/**
 * @Author : josan
 * @Date : 2020/2/13 21:11
 * @Package : leetcode.study.group004.ex0061
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;

        int length = getListLength(dumpHead);

        if (length <= 1) {
            return head;
        }

        return rotateRightInner(dumpHead, k % length);
    }

    private ListNode rotateRightInner(ListNode dumpHead, int k) {
        if (k == 0) {
            return dumpHead.next;
        }

        ListNode firstNode = dumpHead.next;
        ListNode lastNode = dumpHead;
        ListNode prevKNode = dumpHead;

        while (k > 0) {
            lastNode = lastNode.next;
            --k;
        }

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            prevKNode = prevKNode.next;
        }

        dumpHead.next = prevKNode.next;
        lastNode.next = firstNode;
        prevKNode.next = null;

        return dumpHead.next;
    }

    private int getListLength(ListNode head) {
        ListNode p = head.next;
        int len = 0;
        while (p != null) {
            ++len;
            p = p.next;
        }
        return len;
    }
}