package leetcode.study.biggroup001.group005.ex0085;

import org.junit.Assert;
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
    public void testMaximalRectangle() {
        doTestMaximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
                }, 6);
    }

    private void doTestMaximalRectangle(char[][] matrix, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.maximalRectangle(matrix));
    }
}
