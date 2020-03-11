package leetcode.study.week26.ex5339;

import leetcode.study.week26.TreeNode;

/**
 * @Author : josan
 * @Date : 2020/3/8 0:36
 * @Package : leetcode.study.week26.ex5339
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (isValidBST(root)) {
            sum = Math.max(sum, countSumTreePossibleNegative(root));
        }
        sum = Math.max(sum, maxSumBST(root.left));
        sum = Math.max(sum, maxSumBST(root.right));
        return sum;
    }

    private int countSumTreePossibleNegative(TreeNode root) {
        return isAllNegative(root) ? 0 : countSumTree(root);
    }

    private boolean isAllNegative(TreeNode root) {
        boolean result = true;

        if (root == null) {
            return result;
        }

        if (root.val >= 0) {
            return false;
        }

        return isAllNegative(root.left) && isAllNegative(root.right);
    }

    private int countSumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        sum += countSumTree(root.left);
        sum += countSumTree(root.right);
        return sum;
    }

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
