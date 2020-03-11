package leetcode.study.biggroup001.group003.ex0048;

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
    public void testPermuteUnique() {
//        doTestRotate(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}},
//                new int[][]{{7,4,1}, {8,5,2}, {9,6,3}});
        doTestRotate(new int[][]{{5,1,9, 11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}},
                new int[][]{{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}});
    }

    private void doTestRotate(int[][] matrix, int[][] expected) {
        Solution solution = new Solution();
        solution.rotate(matrix);
        Assert.assertArrayEquals("not the same", expected, matrix);
    }
}
