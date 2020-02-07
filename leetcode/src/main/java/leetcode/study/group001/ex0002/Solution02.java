package leetcode.study.group001.ex0002;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0002
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode p = l1, q = l2, cur = dummyHead;
        int carry = 0;

        while(p != null || q != null || carry > 0) {
            int val1 = p != null ? p.val : 0;
            int val2 = q != null ? q.val : 0;

            int sum = carry + val1 + val2;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        return reverse(dummyHead.next);
    }

    private ListNode reverse(ListNode listNode) {
        ListNode head = new ListNode(-1);

        ListNode next = listNode;
        while(next != null) {
            ListNode q = next.next;
            next.next = head.next;
            head.next = next;
            next = q;
        }
        return head.next;
    }
}
