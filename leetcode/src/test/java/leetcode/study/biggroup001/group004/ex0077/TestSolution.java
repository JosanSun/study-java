package leetcode.study.biggroup001.group004.ex0077;

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
    public void testCombine() {
        doTestCombine(4, 2, Arrays.asList(
                Arrays.asList(2,4),Arrays.asList(3,4),Arrays.asList(2,3),
                Arrays.asList(1,2),Arrays.asList(1,3),Arrays.asList(1,4)
        ));
    }

    private void doTestCombine(int n, int k, List<List<Integer>> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.combine(n, k));
    }
}
