package leetcode.study.group001.ex0019;

/**
 * @Author : josan
 * @Date : 2020/2/6 14:18
 * @Package : leetcode.study.group001.ex0019
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        int len = getLength(dumpHead);
        if (head == null || n < 0 || n > len) {
            return head;
        }

        // we need to delete (len - n + 1)th, firstly to find (len - n)th node
        ListNode prev = dumpHead;
        ListNode p = dumpHead.next;
        int curPos = 1;
        while (curPos < len - n + 1) {
            prev = p;
            p = p.next;
            ++curPos;
        }
        prev.next = p.next;
        return dumpHead.next;
    }

    private int getLength(ListNode head) {
        int len = 0;
        ListNode p = head.next;
        while (p != null) {
            ++len;
            p = p.next;
        }
        return len;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}