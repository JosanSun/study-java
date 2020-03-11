package leetcode.study.biggroup001.group005.ex0095;

import leetcode.study.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/3/7 20:24
 * @Package : leetcode.study.group005.ex0095
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateAllTrees(1, n, new ArrayList<>());
    }

    private List<TreeNode> generateAllTrees(int st, int ed, List<TreeNode> allTrees) {
        if (st > ed) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = st; i <= ed; i++) {
            List<TreeNode> leftNodeList = generateAllTrees(st, i - 1, new ArrayList<>());
            List<TreeNode> rightNodeList = generateAllTrees(i + 1, ed, new ArrayList<>());
            for(TreeNode leftNode : leftNodeList) {
                for (TreeNode rightNode : rightNodeList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }
}
