package leetcode.study.biggroup001.group001.ex0015;

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
    public void testThreeSum() {
        doTestThreeSum(new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)));
    }

    private void doTestThreeSum(int[] nums, List<List<Integer>> expected) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);

        Assert.assertEquals("not the same", expected, result);
    }
}
