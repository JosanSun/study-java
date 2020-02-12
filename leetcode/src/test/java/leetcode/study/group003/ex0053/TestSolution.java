package leetcode.study.group003.ex0053;

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
    public void testMaxSubArray() {
       doTestMaxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6);
    }

    private void doTestMaxSubArray(int[] nums, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.maxSubArray(nums));
    }
}
