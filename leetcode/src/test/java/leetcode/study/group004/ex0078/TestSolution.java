package leetcode.study.group004.ex0078;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
    public void testSubsets() {
        doTestSubsets(new int[]{1,2,3}, Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(1),Arrays.asList(2),Arrays.asList(3),
                Arrays.asList(1,2),Arrays.asList(2,3),Arrays.asList(1,3),
                Arrays.asList(1,2,3)
        ));
    }

    private void doTestSubsets(int[] nums, List<List<Integer>> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.subsets(nums));
    }
}
