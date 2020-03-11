package leetcode.study.biggroup001.group002.ex0040;

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
    public void testCombinationSum2() {
//        doTestCombinationSum2(new int[]{10,1,2,7,6,1,5}, 8, Arrays.asList(
//                Arrays.asList(1, 7), Arrays.asList(1, 2, 5), Arrays.asList(2, 6), Arrays.asList(1, 1, 6)
//        ));
        doTestCombinationSum2(new int[]{2,5,2,1,2}, 5, Arrays.asList(
                Arrays.asList(1, 2, 2), Arrays.asList(5)
        ));
    }

    private void doTestCombinationSum2(int[] candidates, int target, List<List<Integer>> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.combinationSum2(candidates, target));
    }
}
