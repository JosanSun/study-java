package leetcode.study.biggroup001.group001.ex0013;

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
    public void testRomanToInt() {
        doTestRomanToInt("III", 3);
        doTestRomanToInt("IV", 4);
        doTestRomanToInt("IX", 9);
        doTestRomanToInt("LVIII", 58);
        doTestRomanToInt("MCMXCIV", 1994);
    }

    private void doTestRomanToInt(String s, int expected) {
        Solution solution = new Solution();
        int result = solution.romanToInt(s);

        Assert.assertEquals("not the same", expected, result);
    }
}
