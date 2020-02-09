package leetcode.study.group003.ex0042;

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
    public void testTrap() {
        doTestTrap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6);
        doTestTrap(new int[]{2, 0, 2}, 2);
        doTestTrap(new int[]{5,2,1,2,1,5}, 14);
    }

    private void doTestTrap(int[] height, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.trap(height));
    }
}
