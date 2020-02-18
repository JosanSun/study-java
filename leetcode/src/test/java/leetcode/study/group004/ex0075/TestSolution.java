package leetcode.study.group004.ex0075;

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
    public void testSetColors() {
        doTestSetColors(new int[]{2,0,2,1,1,0}, new int[]{0,0,1,1,2,2});
        doTestSetColors(new int[]{2,0,1}, new int[]{0,1,2});
        doTestSetColors(new int[]{0,0,0}, new int[]{0,0,0});
        doTestSetColors(new int[]{1,1,1}, new int[]{1,1,1});
        doTestSetColors(new int[]{2,2,2}, new int[]{2,2,2});
        doTestSetColors(new int[]{1,2,2}, new int[]{1,2,2});
        doTestSetColors(new int[]{2,1,2}, new int[]{1,2,2});
        doTestSetColors(new int[]{2,2,1}, new int[]{1,2,2});
    }

    private void doTestSetColors(int[] nums, int[] expected) {
        Solution solution = new Solution();
        solution.sortColors(nums);
        Assert.assertArrayEquals("not the same", expected,
                nums);
    }
}
