package leetcode.study.biggroup001.group005.ex0082;

import leetcode.study.common.ListNode;
import leetcode.study.equal.util.ListNodeHelper;
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
    public void testDeleteDuplicates01() {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode l1 = node1;


        ListNode result = solution.deleteDuplicates(l1);

        ListNode node8 = new ListNode(1);
        ListNode node9 = new ListNode(2);
        ListNode nodeA = new ListNode(5);
        node8.next = node9;
        node9.next = nodeA;
        ListNode expected = node8;

        ListNodeHelper.assertEqualNode(expected, result);
    }

    @Test
    public void testDeleteDuplicates02() {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode l1 = node1;


        ListNode result = solution.deleteDuplicates(l1);

        ListNode node8 = new ListNode(1);
        ListNode node9 = new ListNode(2);
        ListNode nodeA = new ListNode(4);
        node8.next = node9;
        node9.next = nodeA;
        ListNode expected = node8;

        ListNodeHelper.assertEqualNode(expected, result);
    }
}
