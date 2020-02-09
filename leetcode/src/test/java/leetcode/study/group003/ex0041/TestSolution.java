package leetcode.study.group003.ex0041;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testFirstMissingPositive() {
        doTestFirstMissingPositive(new int[]{1,2,0}, 3);
        doTestFirstMissingPositive(new int[]{3,4,-1,1}, 2);
        doTestFirstMissingPositive(new int[]{7,8,9,11,12}, 1);
    }

    private void doTestFirstMissingPositive(int[] nums, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.firstMissingPositive(nums));
    }
}
