package leetcode.study.group002.ex0039;

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
    public void testCombinationSum() {
//        doTestCombinationSum(new int[]{2, 3, 6, 7}, 7, Arrays.asList(
//                Arrays.asList(7), Arrays.asList(2, 2, 3)
//                ));
//        doTestCombinationSum(new int[]{2, 3, 5}, 8, Arrays.asList(
//                Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5)
//        ));
        doTestCombinationSum(new int[]{1, 2}, 2, Arrays.asList(
                Arrays.asList(1, 1), Arrays.asList(2)
        ));
    }

    private void doTestCombinationSum(int[] candidates, int target, List<List<Integer>> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.combinationSum(candidates, target));
    }
}
