package leetcode.study.biggroup001.group003.ex0054;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testSpiralOrder() {
       doTestSpiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}},
               Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
       doTestSpiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}},
               Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7));
    }

    private void doTestSpiralOrder(int[][] matrix, List<Integer> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.spiralOrder(matrix));
    }
}
