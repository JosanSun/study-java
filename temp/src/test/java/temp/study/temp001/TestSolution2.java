package temp.study.temp001;

import org.junit.Assert;
import org.junit.Test;
import temp.study.temp001.Solution;

/**
 * @Author : josan
 * @Date : 2020/2/10 9:33
 * @Package : temp.study
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution2 {
    @Test
    public void testFindShortestWay() {
        doTestFindShortestWay(new int[][]{{0,0,0,0,0}, {0,3,0,2,0}, {0,0,2,0,0}, {0,0,0,0,0}, {0,0,0,0,4}}, 8, 2);
        doTestFindShortestWay(new int[][]{{0,0,0,0,0}, {0,3,0,2,0}, {0,0,2,0,0}, {0,0,0,0,0}, {0,0,0,0,4}}, 4, -1);
        doTestFindShortestWay(new int[][]{{1,2,1}, {0,3,2}, {0,0,4}}, 4, 2);
    }

    private void doTestFindShortestWay(int[][] matrix, int step, int expected) {
        Solution2 solution = new Solution2();
        Assert.assertEquals("not the same", expected, solution.findShortestWay(matrix, step));
    }
}
