package leetcode.study.week179.t02;

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
    public void testFun02() {
//        doTestFun02(new int[]{2,1,3,5,4}, 3);
//        doTestFun02(new int[]{3,2,4,1,5}, 2);
        doTestFun02(new int[]{4,1,2,3}, 1);
        doTestFun02(new int[]{2,1,4,3,6,5}, 3);
        doTestFun02(new int[]{1,2,3,4,5,6}, 6);
    }

    private void doTestFun02(int[] light, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.numTimesAllBlue(light));
    }
}
