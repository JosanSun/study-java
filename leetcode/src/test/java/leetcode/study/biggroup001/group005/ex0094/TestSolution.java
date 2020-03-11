package leetcode.study.biggroup001.group005.ex0094;

import leetcode.study.common.TreeNode;
import leetcode.study.equal.util.TreeNodeHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/3/3 0:20
 * @Package : leetcode.study.group005.ex0085
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testInorderTraversal() {
        doTestInorderTraversal(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,null,2,3)),
                Arrays.asList(1,3,2));
    }

    private void doTestInorderTraversal(TreeNode root, List<Integer> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.inorderTraversal(root));
    }
}
