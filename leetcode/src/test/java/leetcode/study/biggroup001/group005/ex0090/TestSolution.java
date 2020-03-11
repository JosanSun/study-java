package leetcode.study.biggroup001.group005.ex0090;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/3/3 0:20
 * @Package : leetcode.study.group005.ex0085
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testSubsetWithDup() {
//        doTestSubsetWithDup(new int[]{1,2,2}, Arrays.asList(
//                Arrays.asList(2),
//                Arrays.asList(1),
//                Arrays.asList(1,2,2),
//                Arrays.asList(2,2),
//                Arrays.asList(1,2),
//                Arrays.asList()
//        ));

        doTestSubsetWithDup(new int[]{4,4,4,1,4}, Arrays.asList(
                Arrays.asList(4),
                Arrays.asList(1),
                Arrays.asList(1,4),
                Arrays.asList(4,4),
                Arrays.asList(1,4,4),
                Arrays.asList(4,4,4),
                Arrays.asList(1,4,4,4),
                Arrays.asList(4,4,4,4),
                Arrays.asList(1,4,4,4,4)
        ));
    }

    private void doTestSubsetWithDup(int[] nums, List<List<Integer>> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.subsetsWithDup(nums));
    }
}
