package leetcode.study.biggroup001.group002.ex0026;

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
    public void testRemoveDuplicates() {
        doTestRemoveDuplicates(new int[]{1,1,2}, 2);
        doTestRemoveDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}, 5);
    }

    private void doTestRemoveDuplicates(int[] nums, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.removeDuplicates(nums));
    }
}
