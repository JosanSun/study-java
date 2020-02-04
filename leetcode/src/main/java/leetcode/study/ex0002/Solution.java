package leetcode.study.ex0002;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur = head;
        int carry = 0;
        while (p != null || q != null || carry > 0) {
            int num1 = p != null ? p.val : 0;
            int num2 = q != null ? q.val : 0;
            int newValue = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            cur.next = new ListNode(newValue);
            cur = cur.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        return head.next;
    }


//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, cur = dummyHead;
//        int carry = 0;
//
//        while(p != null || q != null || carry > 0) {
//            int val1 = p != null ? p.val : 0;
//            int val2 = q != null ? q.val : 0;
//
//            int sum = carry + val1 + val2;
//            carry = sum / 10;
//            cur.next = new ListNode(sum % 10);
//            cur = cur.next;
//            if (p != null) {
//                p = p.next;
//            }
//            if (q != null) {
//                q = q.next;
//            }
//        }
//
//        return dummyHead.next;
//    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
