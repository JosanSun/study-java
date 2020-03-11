package leetcode.study.biggroup001.group005.ex0091;

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
    public void testNumDecodings() {
        doTestNumDecodings("12", 2);
        doTestNumDecodings("226", 3);
        doTestNumDecodings("0", 0);
        doTestNumDecodings("102", 1);
    }

    private void doTestNumDecodings(String s, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.numDecodings(s));
    }
}
