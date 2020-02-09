package leetcode.study.group002.ex0033;

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
        doTestSearch(new int[]{4,5,6,7,0,1,2}, 0,  4);
        doTestSearch(new int[]{4,5,6,7,0,1,2}, 3,  -1);
        doTestSearch(new int[]{4,5,6,7,0,1,2}, 4,  0);
        doTestSearch(new int[]{5, 1, 3}, 5,  0);
        doTestSearch(new int[]{1, 3}, 0,  -1);
        doTestSearch(new int[]{3, 1}, 1,  1);
        doTestSearch(new int[]{4,5,6,7,8,1,2,3}, 8, 4);
        doTestSearch(new int[]{4,5,6,7,0,1,2,3}, 3, 7);
        doTestSearch(new int[]{5,1,2,3,4}, 1, 1);
    }

    private void doTestSearch(int[] nums, int target, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.search(nums, target));
    }
}
