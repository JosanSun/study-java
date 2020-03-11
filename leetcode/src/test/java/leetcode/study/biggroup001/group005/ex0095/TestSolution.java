package leetcode.study.biggroup001.group005.ex0095;

import leetcode.study.common.TreeNode;
import leetcode.study.equal.util.TreeNodeHelper;
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
    public void testGenerateTrees() {
        doTestGenerateTrees(3,
                Arrays.asList(
                        TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,null,3,2)),
                        TreeNodeHelper.createTreeNodeFromList(Arrays.asList(3,2, null, 1)),
                        TreeNodeHelper.createTreeNodeFromList(Arrays.asList(3,1, null, null,2)),
                        TreeNodeHelper.createTreeNodeFromList(Arrays.asList(2,1,3)),
                        TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,null,2, null,3))
                        ));
    }

    private void doTestGenerateTrees(int n, List<TreeNode> expected) {
        Solution solution = new Solution();

        List<TreeNode> result = solution.generateTrees(n);

        TreeNodeHelper.assertEqualArrayNode(expected, result);
    }
}
