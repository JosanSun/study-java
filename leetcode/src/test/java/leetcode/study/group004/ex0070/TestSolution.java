package leetcode.study.group004.ex0070;

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
    public void testClimbStairs() {
        doTestClimbStairs(1, 1);
        doTestClimbStairs(2, 2);
        doTestClimbStairs(3, 3);
    }

    private void doTestClimbStairs(int n, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.climbStairs(n));
    }
}
