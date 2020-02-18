package leetcode.study.group004.ex0073;

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
    public void testSetZeroes() {
        doTestSetZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}}, new int[][]{{1,0,1},{0,0,0},{1,0,1}});
        doTestSetZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}}, new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}});
    }

    private void doTestSetZeroes(int[][] matrix, int[][] expected) {
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        Assert.assertArrayEquals("not the same", expected,
                matrix);
    }
}
