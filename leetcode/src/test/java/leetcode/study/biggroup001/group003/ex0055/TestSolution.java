package leetcode.study.biggroup001.group003.ex0055;

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
    public void testCanJump() {
       doTestCanJump(new int[]{2,3,1,1,4}, true);
       doTestCanJump(new int[]{3,2,1,0,4}, false);
       doTestCanJump(new int[]{0,1}, false);
       doTestCanJump(new int[]{2,0,0}, true);
    }

    private void doTestCanJump(int[] nums, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.canJump(nums));
    }
}
