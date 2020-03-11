package leetcode.study.biggroup001.group004.ex0063;

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
    public void testUniquePathsWithObstacles() {
        doTestUniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}, 2);
        doTestUniquePathsWithObstacles(new int[][]{{1}}, 0);
    }

    private void doTestUniquePathsWithObstacles(int[][] obstacleGrid, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
