package leetcode.study.biggroup001.group002.ex0023;

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
    public void testMergeKLists() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        ListNode l1 = node1;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        ListNode l2 = node4;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;
        ListNode l3 = node7;

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode node9 = new ListNode(1);
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);
        ListNode nodeD = new ListNode(4);
        ListNode nodeE = new ListNode(4);
        ListNode nodeF = new ListNode(5);
        ListNode nodeG = new ListNode(6);
        node9.next = nodeA;
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;
        nodeF.next = nodeG;
        ListNode expected = node9;

        doTestMergeKLists(lists, expected);
    }

    private void doTestMergeKLists(ListNode[] lists, ListNode expected) {
        Solution solution = new Solution();
        assertEqualNode(expected, solution.mergeKLists(lists));
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
