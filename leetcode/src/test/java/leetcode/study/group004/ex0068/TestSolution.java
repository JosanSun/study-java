package leetcode.study.group004.ex0068;

import org.junit.Assert;
import org.junit.Test;

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
    public void testFullJustify() {
        doTestFullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16,
                Arrays.asList(
                        "This    is    an",
                        "example  of text",
                        "justification.  "
                ));
        doTestFullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16,
                Arrays.asList(
                        "What   must   be",
                        "acknowledgment  ",
                        "shall be        "
                ));
    }

    private void doTestFullJustify(String[] words, int maxWidth, List<String> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.fullJustify(words, maxWidth));
    }
}
