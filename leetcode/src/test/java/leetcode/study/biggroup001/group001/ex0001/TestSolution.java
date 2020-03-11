package leetcode.study.biggroup001.group001.ex0001;

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
    public void testTwoSum() {
        Solution solution = new Solution();

        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);

        int[] expected = {0, 1};
        Assert.assertArrayEquals(expected, result);
    }
}
