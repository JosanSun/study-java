package leetcode.study.group003.ex0049;

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
    public void testGroupAnagrams() {
        doTestGroupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                Arrays.asList(
                        Arrays.asList("ate","eat","tea"),
                        Arrays.asList("nat","tan"),
                        Arrays.asList("bat")
                ));
    }

    private void doTestGroupAnagrams(String[] strs, List<List<String>> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.groupAnagrams(strs));
    }
}
