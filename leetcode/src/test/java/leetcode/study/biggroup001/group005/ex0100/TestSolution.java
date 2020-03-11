package leetcode.study.biggroup001.group005.ex0100;

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
    public void testIsSameTree() {
        doTestIsSameTree(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,2,3)),
                TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,2,3)),
                true);
        doTestIsSameTree(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,2)),
                TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1, null,2)),
                false);
        doTestIsSameTree(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,2,1)),
                TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1, 1,2)),
                false);
    }

    private void doTestIsSameTree(TreeNode p, TreeNode q, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.isSameTree(p, q));
    }
}
