package leetcode.study.week179.t04;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0004
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testFun04() {
//        doTestFun04(7, new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}},2, 4, 0.1666666666);
//        doTestFun04(7, new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}},1, 7, 0.33333333333);
//        doTestFun04(7, new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}},20, 6, 0.166666666);
//        doTestFun04(3, new int[][]{{2,1},{3,2}},1, 2, 1.0);
//        doTestFun04(8, new int[][]{{2,1},{3,2},{4,1}, {5,1}, {6,4}, {7,1}, {8,7}},7, 7, 0.0);
        doTestFun04(8, new int[][]{{}},1, 1, 1.0);
    }

    private void doTestFun04(int n, int[][] edges, int t, int target, double expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.frogPosition(n, edges, t, target), 0.00001);
    }
}
