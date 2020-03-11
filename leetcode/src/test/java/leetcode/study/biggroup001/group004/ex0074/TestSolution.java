package leetcode.study.biggroup001.group004.ex0074;

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
    public void testSearchMatrix() {
        doTestSearchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 3, true);
        doTestSearchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 13, false);
        doTestSearchMatrix(new int[0][0], 1, false);
    }

    private void doTestSearchMatrix(int[][] matrix, int target, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.searchMatrix(matrix, target));
    }
}
