package leetcode.study.biggroup001.group005.ex0081;

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
    public void testSearch() {
        doTestSearch(new int[]{2,5,6,0,0,1,2}, 0, true);
        doTestSearch(new int[]{2,5,6,0,0,1,2}, 3, false);
        doTestSearch(new int[]{2,5,6,0,0,1,1,1,1,1,2}, -1, false);
        doTestSearch(new int[]{2,5,6,0,0,1,1,1,1,1,2}, 100, false);
        doTestSearch(new int[]{2,5,6,0,0,1,1,1,1,1,2}, 1, true);
        doTestSearch(new int[]{3,1,1,1}, 3, true);
    }

    private void doTestSearch(int[] nums, int target, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.search(nums, target));
    }
}
