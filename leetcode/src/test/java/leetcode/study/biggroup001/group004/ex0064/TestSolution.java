package leetcode.study.biggroup001.group004.ex0064;

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
    public void testMinPathSum() {
        doTestMinPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}, 7);
        doTestMinPathSum(new int[][]{{1,2,5},{3,2,1}}, 6);
        doTestMinPathSum(new int[][]{{1,2},{5,6},{1,1}}, 8);
    }

    private void doTestMinPathSum(int[][] grid, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.minPathSum(grid));
    }
}
