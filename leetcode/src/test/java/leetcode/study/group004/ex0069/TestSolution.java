package leetcode.study.group004.ex0069;

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
    public void testMySqrt() {
        doTestMySqrt(4, 2);
        doTestMySqrt(8, 2);
        doTestMySqrt(3, 1);
        doTestMySqrt(2147395599, 46339);
        doTestMySqrt(2147483647, 46340);
    }

    private void doTestMySqrt(int x, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.mySqrt(x));
    }
}
