package leetcode.study.biggroup001.group005.ex0083;

import leetcode.study.common.ListNode;

/**
 * @Author : josan
 * @Date : 2020/2/23 22:28
 * @Package : leetcode.study.group005.ex0083
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        head = dumpHead;
        return deleteDuplicatesInner(head);
    }

    private ListNode deleteDuplicatesInner(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && cur.val == next.val) {
                cur = next;
                next = next.next;
            }
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }

        return head.next;
    }
}
