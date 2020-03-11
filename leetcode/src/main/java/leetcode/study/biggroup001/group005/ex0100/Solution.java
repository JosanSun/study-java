package leetcode.study.biggroup001.group005.ex0100;

import leetcode.study.common.TreeNode;

/**
 * @Author : josan
 * @Date : 2020/3/7 21:40
 * @Package : leetcode.study.group005.ex0100
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeInner(p, q);
    }

    private boolean isSameTreeInner(TreeNode lhs, TreeNode rhs) {
        boolean result = false;
        if (lhs == null && rhs == null) {
            return true;
        } else if (lhs == null || rhs == null) {
            return false;
        } else {
            if (lhs.val == rhs.val) {
                result = isSameTreeInner(lhs.left, rhs.left)
                        && isSameTreeInner(lhs.right, rhs.right);
            } else {
                return false;
            }
        }
        return result;
    }
}
