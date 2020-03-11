package leetcode.study.biggroup001.group003.ex0047;

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
    public void testPermuteUnique() {
        doTestPermuteUnique(new int[]{1,1,3}, Arrays.asList(
                Arrays.asList(1,1,2),
                Arrays.asList(1,2,1),
                Arrays.asList(2,1,1)
        ));
    }

    private void doTestPermuteUnique(int[] nums, List<List<Integer>> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.permuteUnique(nums));
    }
}
