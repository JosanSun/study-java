package leetcode.study.group004.ex0079;

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
    public void testExist() {
        doTestExist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}},
                "ABCCED", true);
        doTestExist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}},
                "SEE", true);
        doTestExist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}},
                "ABCB", false);
        doTestExist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}},
                "A", true);
    }

    private void doTestExist(char[][] board, String word, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.exist(board, word));
    }
}
