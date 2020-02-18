package leetcode.study.group004.ex0080;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
    public void testRemoveDuplicates() {
        doTestRemoveDuplicates(new int[]{1,1,1,2,2,3}, 5);
        doTestRemoveDuplicates(new int[]{0,0,1,1,1,1,2,3,3}, 7);
    }

    private void doTestRemoveDuplicates(int[] nums, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.removeDuplicates(nums));
    }
}
