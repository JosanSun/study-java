package leetcode.study.biggroup001.group001.ex0020;

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
    public void testIsValid() {
        doTestIsValid("()", true);
        doTestIsValid("()[]{}", true);
        doTestIsValid("(]", false);
        doTestIsValid("([)]", false);
        doTestIsValid("{[]}", true);
    }

    private void doTestIsValid(String s, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.isValid(s));
    }
}
