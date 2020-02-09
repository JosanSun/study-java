package leetcode.study.group002.ex0035;

import org.junit.Assert;
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
    public void testSearchInsert() {
        doTestSearchInsert(new int[]{1,3,5,6}, 5, 2);
        doTestSearchInsert(new int[]{1,3,5,6}, 2, 1);
        doTestSearchInsert(new int[]{1,3,5,6}, 7, 4);
        doTestSearchInsert(new int[]{1,3,5,6}, 0, 0);
    }

    private void doTestSearchInsert(int[] nums, int target, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.searchInsert(nums, target));
    }
}
