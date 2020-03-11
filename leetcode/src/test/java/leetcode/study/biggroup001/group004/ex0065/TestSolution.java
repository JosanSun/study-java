package leetcode.study.biggroup001.group004.ex0065;

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
    public void testIsNumber() {
        doTestIsNumber("0", true);
        doTestIsNumber(" 0.1 ", true);
        doTestIsNumber("abc", false);
        doTestIsNumber("1 a", false);
        doTestIsNumber("2e10", true);
        doTestIsNumber(" -90e3   ", true);
        doTestIsNumber(" -90.e3   ", true);
        doTestIsNumber(" 1e", false);
        doTestIsNumber("e3", false);
        doTestIsNumber(" 6e-1", true);
        doTestIsNumber(" 99e2.5 ", false);
        doTestIsNumber("53.5e93", true);
        doTestIsNumber(" --6 ", false);
        doTestIsNumber("-+3", false);
        doTestIsNumber("95a54e53", false);
        doTestIsNumber(".", false);
        doTestIsNumber(".1", true);
        doTestIsNumber("e", false);
        doTestIsNumber("e", false);
        doTestIsNumber("-.1", true);
        doTestIsNumber("1.", true);
        doTestIsNumber("005047e+6", true);
        doTestIsNumber("46.e3", true);
        doTestIsNumber(".2e81", true);
        doTestIsNumber("+e", false);
        doTestIsNumber("+e3", false);
        doTestIsNumber(".e1", false);
        doTestIsNumber("-.", false);
        doTestIsNumber(" +0e-", false);
    }

    private void doTestIsNumber(String s, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.isNumber(s));
    }
}
