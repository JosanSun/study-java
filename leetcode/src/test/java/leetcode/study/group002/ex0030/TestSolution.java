package leetcode.study.group002.ex0030;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
    public void testFindSubstring() {
        doTestFindSubstring("barfoothefoobarman", new String[]{"foo","bar"}, Arrays.asList(0, 9));
        doTestFindSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"},
                new ArrayList<>());
        doTestFindSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}, Arrays.asList(8));
        doTestFindSubstring("aaaaaaaa", new String[]{"aa","aa","aa"}, Arrays.asList(0, 1, 2));
    }

    private void doTestFindSubstring(String s, String[] words, List<Integer> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.findSubstring(s, words));
    }
}
