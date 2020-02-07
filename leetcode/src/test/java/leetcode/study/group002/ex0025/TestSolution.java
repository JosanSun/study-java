package leetcode.study.group002.ex0025;

import leetcode.study.common.ListNode;
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
    public void testReverseKGroup() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = node1;

        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(3);
        ListNode nodeA = new ListNode(5);
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = nodeA;
        ListNode expected1 = node6;
        doTestReverseKGroup(head, 2, expected1);
    }

    @Test
    public void testReverseKGroup02() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = node1;

        ListNode nodeB = new ListNode(3);
        ListNode nodeC = new ListNode(2);
        ListNode nodeD = new ListNode(1);
        ListNode nodeE = new ListNode(4);
        ListNode nodeF = new ListNode(5);
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;
        ListNode expected2 = nodeB;
        doTestReverseKGroup(head, 3, expected2);
    }

    private void doTestReverseKGroup(ListNode head, int k, ListNode expected) {
        Solution solution = new Solution();
        assertEqualNode(expected, solution.reverseKGroup(head, k));
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
