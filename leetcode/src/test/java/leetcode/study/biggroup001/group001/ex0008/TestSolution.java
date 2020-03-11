package leetcode.study.biggroup001.group001.ex0008;

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
    public void testMyAtoi() {
        doTestMyAtoi("42", 42);
        doTestMyAtoi("     -42", -42);
        doTestMyAtoi("4193 with words", 4193);
        doTestMyAtoi("words and 987", 0);
        doTestMyAtoi("-91283472332", -2147483648);
        doTestMyAtoi("", 0);
        doTestMyAtoi("  0000000000012345678", 12345678);
        doTestMyAtoi("2147483648", 2147483647);
        doTestMyAtoi("-2147483649", -2147483648);
    }

    private void doTestMyAtoi(String str, int expected) {
        Solution solution = new Solution();
        int result = solution.myAtoi(str);

        Assert.assertEquals("not the same", expected, result);
    }
}
