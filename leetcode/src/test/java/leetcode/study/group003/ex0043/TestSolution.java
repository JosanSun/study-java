package leetcode.study.group003.ex0043;

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
    public void testMultiply() {
//        doTestMultiply("2", "3", "6");
        doTestMultiply("123", "456", "56088");
    }

    private void doTestMultiply(String num1, String num2, String expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.multiply(num1, num2));
    }
}
