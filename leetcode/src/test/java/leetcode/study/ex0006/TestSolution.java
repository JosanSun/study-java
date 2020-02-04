package leetcode.study.ex0006;

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
    public void testConvert() {
        doTestConvert("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
        doTestConvert("PAYPALISHIRING", 4, "PINALSIGYAHRPI");
    }

    private void doTestConvert(String s, int numRows, String expected) {
        Solution solution = new Solution();
        String result = solution.convert(s, numRows);

        Assert.assertEquals("not the same", expected, result);
    }
}
