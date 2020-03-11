package leetcode.study.biggroup001.group005.ex0099;

import leetcode.study.common.TreeNode;
import leetcode.study.equal.util.TreeNodeHelper;
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
    public void testRecoverTree() {
        doTestRecoverTree(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,3,null,null,2)),
                TreeNodeHelper.createTreeNodeFromList(Arrays.asList(3,1,null,null,2)));
        doTestRecoverTree(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(3,1,4,null,null,2)),
                TreeNodeHelper.createTreeNodeFromList(Arrays.asList(2,1,4,null,null,3)));
    }

    private void doTestRecoverTree(TreeNode root, TreeNode expected) {
        Solution solution = new Solution();
        solution.recoverTree(root);

        TreeNodeHelper.assertEqualNode(expected, root);
    }
}
