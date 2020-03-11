package leetcode.study.week179.t03;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0003
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testFun03() {
        doTestFun03(1, 0, new int[]{-1}, new int[]{0}, 0);
        doTestFun03(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}, 1);
        doTestFun03(7, 6, new int[]{1,2,3,4,5,6,-1}, new int[]{0,6,5,4,3,2,1}, 21);
        doTestFun03(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}, 3);
        doTestFun03(4, 2, new int[]{3,3,-1,2}, new int[]{0,0,162,914}, 1076);

    }

    private void doTestFun03(int n, int headID, int[] manager, int[] informTime, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.numOfMinutes(n, headID, manager, informTime));
    }
}
