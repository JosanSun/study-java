package leetcode.study.biggroup001.group002.ex0034;

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
    public void testSearchRange() {
        doTestSearchRange(new int[]{5,7,7,8,8,10}, 8,  new int[]{3, 4});
        doTestSearchRange(new int[]{5,7,7,8,8,10}, 6,  new int[]{-1, -1});
        doTestSearchRange(new int[]{5,7,7,8,8,10}, 7,  new int[]{1, 2});
        doTestSearchRange(new int[]{5,7,7,8,8,10}, 0,  new int[]{-1, -1});
        doTestSearchRange(new int[]{5,7,7,8,8,10}, 100,  new int[]{-1, -1});
    }

    private void doTestSearchRange(int[] nums, int target, int[] expected) {
        Solution solution = new Solution();
        Assert.assertArrayEquals("not the same", expected,
                solution.searchRange(nums, target));
    }
}
