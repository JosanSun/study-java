package leetcode.study.group004.ex0066;

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
    public void testPlusOne() {
        doTestPlusOne(new int[]{1,2,3}, new int[]{1,2,4});
        doTestPlusOne(new int[]{4,3,2,1}, new int[]{4,3,2,2});
        doTestPlusOne(new int[]{0}, new int[]{1});
        doTestPlusOne(new int[]{9}, new int[]{1,0});
        doTestPlusOne(new int[]{8,9,9,9}, new int[]{9,0,0,0});
    }

    private void doTestPlusOne(int[] digits, int[] expected) {
        Solution solution = new Solution();
        Assert.assertArrayEquals("not the same", expected,
                solution.plusOne(digits));
    }
}
