package leetcode.study.biggroup001.group002.ex0021;

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
    public void testMergeTwoLists() {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        ListNode l1 = node1;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        ListNode l2 = node4;


        ListNode result = solution.mergeTwoLists(l1, l2);

        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(1);
        ListNode node9 = new ListNode(2);
        ListNode nodeA = new ListNode(3);
        ListNode nodeB = new ListNode(4);
        ListNode nodeC = new ListNode(4);
        node7.next = node8;
        node8.next = node9;
        node9.next = nodeA;
        nodeA.next = nodeB;
        nodeB.next = nodeC;
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
