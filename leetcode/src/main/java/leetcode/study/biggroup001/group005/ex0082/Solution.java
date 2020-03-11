package leetcode.study.biggroup001.group005.ex0082;

import leetcode.study.common.ListNode;

/**
 * @Author : josan
 * @Date : 2020/2/23 21:50
 * @Package : leetcode.study.group005.ex0082
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

        boolean isDuplicate = false;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val == cur.val) {
                cur = cur.next;
                next = next.next;
                isDuplicate = true;
            } else {
                if (isDuplicate) {
                    cur = cur.next;
                } else {
                    pre.next = cur;
                    pre = cur;
                    cur = cur.next;
                }
                isDuplicate = false;
            }
        }
        pre.next = null;


        return head.next;
    }
}