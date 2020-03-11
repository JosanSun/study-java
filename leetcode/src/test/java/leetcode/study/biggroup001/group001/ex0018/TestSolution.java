package leetcode.study.biggroup001.group001.ex0018;

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
    public void testFourSum() {
        doTestFourSum(new int[]{1, 0, -1, 0, -2, 2}, 0, Arrays.asList(
                Arrays.asList(-1, 0, 0, 1),
                Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2, 0, 0, 2)
        ));
    }

    private void doTestFourSum(int[] nums, int target, List<List<Integer>> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.fourSum(nums, target));
    }
}
