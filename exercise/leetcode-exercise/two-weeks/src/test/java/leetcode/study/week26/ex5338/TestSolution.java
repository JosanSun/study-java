package leetcode.study.week26.ex5338;

import leetcode.study.week26.TreeNode;
import leetcode.study.week26.TreeNodeHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testFindTheLongestSubstring() {
//        doTestFindTheLongestSubstring(
//                TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1)),
//                3);
        doTestFindTheLongestSubstring(
                TreeNodeHelper.createTreeNodeFromList(Arrays.asList(2,8,6,1,1,7,9,8,9,3,1,4,8,null,5,3,4,10,10,2,null,5,null,3,7,null,3,null,4,6,2,8,4,5,null,null,9,null,6,null,6,null,null,2,2,null,3,2,null,null,8,1,9,8,8,5,10,null,9,null,8,null,null,null,null,5,7,2,10,null,null,null,null,null,null,3,null,2,null,null,null,8,7,null,null,3,1,null,3,null,null,null,7,1,null,3,null,null,null,null,2,null,2,null,4,7,4,null,null,null,9,null,null,null,null,8,8,null,null,null,null,7,2,1,4,null,4,7,null,5,9,null,7,9,7,null,10,9,6,null,null,7,2,3,null,2,null,9,5,9,null,null,5,null,5,9,null,null,null,null,9,null,null,null,null,null,7,null,null,null,null,null,null,null,9,null,4,1,null,null,null,null,4,4,null,null,4,null,null,null,4)),
                8);
    }

    private void doTestFindTheLongestSubstring(TreeNode root, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.longestZigZag(root));
    }
}
