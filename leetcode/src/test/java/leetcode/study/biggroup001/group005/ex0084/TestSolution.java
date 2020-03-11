package leetcode.study.biggroup001.group005.ex0084;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author : josan
 * @Date : 2020/2/25 1:24
 * @Package : leetcode.study.group005.ex0084
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testLargestRectangleArea() {
        doTestLargestRectangleArea(new int[]{2,1,5,6,2,3}, 10);
        doTestLargestRectangleArea(new int[]{0,0}, 0);
    }

    private void doTestLargestRectangleArea(int[] heights, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.largestRectangleArea(heights));
    }
}
