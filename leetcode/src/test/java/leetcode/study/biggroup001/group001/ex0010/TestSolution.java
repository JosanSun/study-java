package leetcode.study.biggroup001.group001.ex0010;

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
    public void testIsMatch() {
        doTestIsMatch("aa", "a", false);
        doTestIsMatch("aa", "a*", true);
        doTestIsMatch("ab", ".*", true);
        doTestIsMatch("aab", "c*a*b*", true);
        doTestIsMatch("mississippi", "mis*is*p*.", false);
    }

    private void doTestIsMatch(String s, String p, boolean expected) {
        Solution solution = new Solution();
        boolean result = solution.isMatch(s, p);

        Assert.assertEquals("not the same", expected, result);
    }
}
