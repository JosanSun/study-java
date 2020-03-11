package leetcode.study.biggroup001.group001.ex0002;

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
    public void testAddTwoNumbers() {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;


        ListNode l1 = node1;
        ListNode l2 = node4;
        ListNode result = solution.addTwoNumbers(l1, l2);

        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(0);
        ListNode node9 = new ListNode(8);
        node7.next = node8;
        node8.next = node9;
        ListNode expected = node7;

        assertEqualNode(expected, result);
    }

    @Test
    public void testAddTwoNumbers02() {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        node1.next = node2;

        ListNode node4 = new ListNode(0);


        ListNode l1 = node1;
        ListNode l2 = node4;
        ListNode result = solution.addTwoNumbers(l1, l2);

        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        node7.next = node8;
        ListNode expected = node7;

        assertEqualNode(expected, result);
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
