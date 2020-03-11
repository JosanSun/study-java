package leetcode.study.biggroup001.group002.ex0024;

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
    public void testSwapPairs() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = node1;


        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(3);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode expected = node5;

        doTestSwapPairs(head, expected);
    }

    private void doTestSwapPairs(ListNode head, ListNode expected) {
        Solution solution = new Solution();
        assertEqualNode(expected, solution.swapPairs(head));
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
