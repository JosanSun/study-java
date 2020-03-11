package leetcode.study.biggroup001.group001.ex0004;

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
    public void testFindMedianSortedArrays() {
        doTestFindMedianSortedArrays(new int[]{1, 3}, new int[]{2}, 2.0);
        doTestFindMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}, 2.5);
        doTestFindMedianSortedArrays(new int[]{1, 1, 3, 3}, new int[]{1, 1, 3, 3}, 2.0);
        doTestFindMedianSortedArrays(new int[]{1, 4, 5, 6}, new int[]{2, 3, 7, 8}, 4.5);
        doTestFindMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, 4.5);
        doTestFindMedianSortedArrays(new int[]{1, 5, 6, 7}, new int[]{2, 3, 4, 8, 9, 10}, 5.5);
        doTestFindMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}, 0.0);
    }

    private void doTestFindMedianSortedArrays(int[] num1, int[] num2,
                                              double expected) {
        Solution solution = new Solution();
        double result = solution.findMedianSortedArrays(num1, num2);

        Assert.assertEquals("not the same", expected, result, 0.05);
    }
}
