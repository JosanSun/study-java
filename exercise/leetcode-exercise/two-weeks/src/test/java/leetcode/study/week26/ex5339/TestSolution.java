package leetcode.study.week26.ex5339;

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
    public void testMaxSumBST() {
        doTestMaxSumBST(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(1,4,3,2,4,2,5,null,null,null,null,null,null,4,6)),
                20);
        doTestMaxSumBST(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(4,3,null,1,2)),
                2);
        doTestMaxSumBST(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(-4,-2,-5)),
                0);
        doTestMaxSumBST(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(2,1,3)),
                6);
        doTestMaxSumBST(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(5,4,8,3,null,6,3)),
                7);
        doTestMaxSumBST(TreeNodeHelper.createTreeNodeFromList(Arrays.asList(9,4,10,null,null,6,11)),
                27);
    }

    private void doTestMaxSumBST(TreeNode root, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.maxSumBST(root));
    }
}
