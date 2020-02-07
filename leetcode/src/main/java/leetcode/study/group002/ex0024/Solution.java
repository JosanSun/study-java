package leetcode.study.group002.ex0024;

import leetcode.study.common.ListNode;

/**
 * @Author : josan
 * @Date : 2020/2/6 21:28
 * @Package : leetcode.study.group002.ex0024
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;

        swapPairsInner(dumpHead);
        return dumpHead.next;
    }

    private void swapPairsInner(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                break;
            } else {
                ListNode tmp = next.next;
                prev.next = next;
                next.next = cur;
                cur.next = tmp;

                prev = cur;
                cur = tmp;
            }
        }
    }
}

