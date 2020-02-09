package leetcode.study.group003.ex0045;

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
    public void testJump() {
        doTestJump(new int[]{2,3,1,1,4}, 2);
    }

    private void doTestJump(int[] nums, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.jump(nums));
    }
}
