package leetcode.study.group003.ex0059;

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
    public void testGenerateMatrix() {
       doTestGenerateMatrix(3, new int[][]{{1,2,3},{8,9,4},{7,6,5}});
    }

    private void doTestGenerateMatrix(int n, int[][] expected) {
        Solution solution = new Solution();
        Assert.assertArrayEquals("not the same", expected,
                solution.generateMatrix(n));
    }
}
