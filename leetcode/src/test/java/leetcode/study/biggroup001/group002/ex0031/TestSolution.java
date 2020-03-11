package leetcode.study.biggroup001.group002.ex0031;

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
    public void testNextPermutation() {
        doTestNextPermutation(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        doTestNextPermutation(new int[]{3, 2, 1}, new int[]{1, 2, 3});
        doTestNextPermutation(new int[]{1, 1, 5}, new int[]{1, 5, 1});
    }

    private void doTestNextPermutation(int[] nums, int[] expected) {
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        Assert.assertArrayEquals("not the same", expected, nums);
    }
}
