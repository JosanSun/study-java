package leetcode.study.biggroup001.group005.ex0086;

import leetcode.study.common.ListNode;
import leetcode.study.equal.util.ListNodeHelper;
import org.junit.Test;

/**
 * @Author : josan
 * @Date : 2020/3/3 0:20
 * @Package : leetcode.study.group005.ex0085
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testPartition() {
        doTestPartition(ListNodeHelper.createListNodeFromArray(new int[]{1,4,3,2,5,2}), 3,
                ListNodeHelper.createListNodeFromArray(new int[]{1,2,2,4,3,5}));
    }

    private void doTestPartition(ListNode head, int x, ListNode expected) {
        Solution solution = new Solution();
        solution.partition(head, x);

        ListNodeHelper.assertEqualNode(head, expected);
    }
}
