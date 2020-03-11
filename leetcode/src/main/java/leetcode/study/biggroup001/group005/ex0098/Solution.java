package leetcode.study.biggroup001.group005.ex0098;

import leetcode.study.common.TreeNode;

/**
 * @Author : josan
 * @Date : 2020/3/7 21:00
 * @Package : leetcode.study.group005.ex0098
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTInner(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTInner(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        long value = (long)root.val;
        if (min < value && value < max) {
            return isValidBSTInner(root.left, min, value)
                    && isValidBSTInner(root.right, value, max);
        } else {
            return false;
        }
    }
}