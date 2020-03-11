package leetcode.study.biggroup001.group005.ex0098;

import leetcode.study.common.TreeNode;
import leetcode.study.equal.util.TreeNodeHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author : josan
 * @Date : 2020/3/3 0:20
 * @Package : leetcode.study.group005.ex0085
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testIsValidBST() {
        doTestIsValidBST(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(2,1,3)), true);
        doTestIsValidBST(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(5,1,4,null,null,3,6)), false);
        doTestIsValidBST(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1, 1)), false);
    }

    private void doTestIsValidBST(TreeNode root, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.isValidBST(root));
    }
}
