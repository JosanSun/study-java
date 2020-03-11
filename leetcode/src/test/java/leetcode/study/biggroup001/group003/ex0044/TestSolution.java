package leetcode.study.biggroup001.group003.ex0044;

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
        doTestIsMatch("aa", "*", true);
        doTestIsMatch("cb", "?a", false);
        doTestIsMatch("adceb", "*a*b", true);
        doTestIsMatch("acdcb", "a*c?b", false);
        doTestIsMatch("abbaaaabbbbbababbbbbbbbaaabaabbabaabbaaabbbbabbbbab",
                "a*aaba***b**a*a********b", true);
        doTestIsMatch("c", "*?*", true);
        doTestIsMatch("mississippi", "m??*ss*?i*pi", false);
    }

    private void doTestIsMatch(String s, String p, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.isMatch(s, p));
    }
}
