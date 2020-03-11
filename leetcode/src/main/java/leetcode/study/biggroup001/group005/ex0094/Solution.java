package leetcode.study.biggroup001.group005.ex0094;

import leetcode.study.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author : josan
 * @Date : 2020/3/7 14:44
 * @Package : leetcode.study.group005.ex0094
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = root.left;

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.peek();
            result.add(node.val);
            stack.pop();
            p = node.right;
        }
        return result;
    }
}
