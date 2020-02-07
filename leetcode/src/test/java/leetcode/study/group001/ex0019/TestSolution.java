package leetcode.study.group001.ex0019;

import org.junit.Test;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testRemoveNthFromEnd() {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode l1 = node1;
        ListNode result = solution.removeNthFromEnd(l1, 2);

        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(5);
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        ListNode expected = node6;

        assertEqualNode(expected, result);
    }

    @Test
    public void testRemoveNthFromEnd02() {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode l1 = node1;
        ListNode result = solution.removeNthFromEnd(l1, 1);

        assertEqualNode(null, result);
    }



    private void assertEqualNode(ListNode lhs, ListNode rhs) {
        while (lhs != null && rhs != null) {
            if (lhs.val == rhs.val) {
                lhs = lhs.next;
                rhs = rhs.next;
            } else {
                break;
            }
        }

        if (lhs != null || rhs != null) {
            System.out.println("They are not equal");
        } else {
            System.out.println("They are equal");
        }
    }
}
