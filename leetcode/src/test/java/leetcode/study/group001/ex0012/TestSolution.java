package leetcode.study.group001.ex0012;

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
    public void testIntToRoman() {
        doTestIntToRoman(3, "III");
        doTestIntToRoman(4, "IV");
        doTestIntToRoman(9, "IX");
        doTestIntToRoman(58, "LVIII");
        doTestIntToRoman(1994, "MCMXCIV");
    }

    private void doTestIntToRoman(int num, String expected) {
        Solution solution = new Solution();
        String result = solution.intToRoman(num);

        Assert.assertEquals("not the same", expected, result);
    }
}
