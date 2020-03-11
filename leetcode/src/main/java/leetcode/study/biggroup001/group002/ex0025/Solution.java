package leetcode.study.biggroup001.group002.ex0025;

import leetcode.study.common.ListNode;

/**
 * @Author : josan
 * @Date : 2020/2/6 21:49
 * @Package : leetcode.study.group002.ex0025
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;

        reverseKGroupInner(dumpHead, k);
        return dumpHead.next;
    }

    private void reverseKGroupInner(ListNode head, int k) {
        ListNode prev = head;
        ListNode cur = head.next;
        int curSteps = 1;
        while (cur != null) {
            // next指向cur之后的第k个元素
            ListNode next = cur.next;
            while (next != null && curSteps < k) {
                ++curSteps;
                next = next.next;
            }
            // 无须倒置
            if (curSteps < k) {
                return ;
            }

            ListNode tempHead = new ListNode(-1);
            ListNode tail = prev.next;
            while (cur != next) {
                ListNode tmp = cur.next;
                cur.next = tempHead.next;
                tempHead.next = cur;
                cur = tmp;
            }

            prev.next = tempHead.next;
            tail.next = next;

            // 设置到下一个状态点
            prev = tail;
            curSteps = 1;
        }
    }
}