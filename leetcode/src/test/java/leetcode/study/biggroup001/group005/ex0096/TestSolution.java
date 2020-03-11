package leetcode.study.biggroup001.group005.ex0096;

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
    public void testNumTrees() {
        doTestNumTrees(1, 1);
        doTestNumTrees(2, 2);
        doTestNumTrees(3, 5);
        doTestNumTrees(4, 14);
    }

    private void doTestNumTrees(int n, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.numTrees(n));
    }
}
