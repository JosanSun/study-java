package leetcode.study.biggroup001.group005.ex0092;

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
        doTestReverseBetween(ListNodeHelper.createListNodeFromArray(new int[]{1,2,3,4,5}), 2,4,
                ListNodeHelper.createListNodeFromArray(new int[]{1,4,3,2,5}));
    }

    private void doTestReverseBetween(ListNode head, int m, int n, ListNode expected) {
        Solution solution = new Solution();
        solution.reverseBetween(head, m, n);

        ListNodeHelper.assertEqualNode(head, expected);
    }
}
