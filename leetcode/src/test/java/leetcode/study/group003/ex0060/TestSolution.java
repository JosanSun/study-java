package leetcode.study.group003.ex0060;

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
    public void testGetPermutation() {
       doTestGetPermutation(3, 3, "213");
       doTestGetPermutation(4, 9, "2314");
    }

    private void doTestGetPermutation(int n, int k, String expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.getPermutation(n, k));
    }
}
