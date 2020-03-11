package leetcode.study.biggroup001.group005.ex0088;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author : josan
 * @Date : 2020/3/3 0:20
 * @Package : leetcode.study.group005.ex0085
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testMerge() {

        doTestMerge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3, new int[]{1,2,2,3,5,6});
    }

    private void doTestMerge(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals("not the same", expected,
                nums1);
    }
}
