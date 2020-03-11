package leetcode.study.biggroup001.group004.ex0067;

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
    public void testAddBinary() {
        doTestAddBinary("11", "1", "100");
        doTestAddBinary("1010", "1011", "10101");
    }

    private void doTestAddBinary(String a, String b, String expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.addBinary(a, b));
    }
}
