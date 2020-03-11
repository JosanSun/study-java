package leetcode.study.biggroup001.group001.ex0011;

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
    public void testMaxArea() {
        doTestMaxArea(new int[]{1,8,6,2,5,4,8,3,7}, 49);
    }

    private void doTestMaxArea(int[] height, int expected) {
        Solution solution = new Solution();
        int result = solution.maxArea(height);

        Assert.assertEquals("not the same", expected, result);
    }
}
