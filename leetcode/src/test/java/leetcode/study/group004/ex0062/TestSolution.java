package leetcode.study.group004.ex0062;

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
    public void testUniquePaths() {
        doTestUniquePaths(3, 2, 3);
        doTestUniquePaths(7, 3, 28);
    }

    private void doTestUniquePaths(int m, int n, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.uniquePaths(m, n));
    }
}
