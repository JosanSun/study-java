package leetcode.study.biggroup001.group002.ex0029;

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
    public void testDivide() {
        doTestDivide(10, 3, 3);
        doTestDivide(7, -3, -2);
        doTestDivide(1, 1, 1);
        doTestDivide(-2147483648, -1, 2147483647);
    }

    private void doTestDivide(int dividend, int divisor, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.divide(dividend, divisor));
    }
}
