package leetcode.study.group003.ex0050;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testMyPow() {
       doTestMyPow(2.0, 10, 1024.0);
       doTestMyPow(2.1, 3, 9.26100);
       doTestMyPow(2.00, -2, 0.25000);
    }

    private void doTestMyPow(double x, int n, double expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.myPow(x, n), 0.002);
    }
}
