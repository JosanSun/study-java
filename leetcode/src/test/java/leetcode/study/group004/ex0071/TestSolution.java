package leetcode.study.group004.ex0071;

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
    public void testSimplifyPath() {
        doTestSimplifyPath("/home/", "/home");
        doTestSimplifyPath("/../", "/");
        doTestSimplifyPath("/home//foo/", "/home/foo");
        doTestSimplifyPath("/a/./b/../../c/", "/c");
    }

    private void doTestSimplifyPath(String path, String expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.simplifyPath(path));
    }
}
