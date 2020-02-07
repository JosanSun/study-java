package leetcode.study.group001.ex0007;

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
    public void testReverse() {
        doTestReverse(123, 321);
        doTestReverse(-123, -321);
        doTestReverse(-120, -21);
        doTestReverse(120, 21);
        doTestReverse(563847412, 214748365);
    }

    private void doTestReverse(int x, int expected) {
        Solution solution = new Solution();
        int result = solution.reverse(x);

        Assert.assertEquals("not the same", expected, result);
    }
}
