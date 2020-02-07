package leetcode.study.group001.ex0016;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
    public void testThreeSumClosest() {
        doTestThreeSumClosest(new int[]{-1, 2, 1, -4}, 1, 2);
    }

    private void doTestThreeSumClosest(int[] nums, int target, int expected) {
        Solution solution = new Solution();
        int result = solution.threeSumClosest(nums, target);

        Assert.assertEquals("not the same", expected, result);
    }
}
