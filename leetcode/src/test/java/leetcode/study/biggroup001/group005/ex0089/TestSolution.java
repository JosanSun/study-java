package leetcode.study.biggroup001.group005.ex0089;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/3/3 0:20
 * @Package : leetcode.study.group005.ex0085
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testGrayCode() {
        doTestGrayCode(0, Arrays.asList(0));
        doTestGrayCode(2, Arrays.asList(0, 2, 3, 1));
    }

    private void doTestGrayCode(int n, List<Integer> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.grayCode(n));
    }
}
