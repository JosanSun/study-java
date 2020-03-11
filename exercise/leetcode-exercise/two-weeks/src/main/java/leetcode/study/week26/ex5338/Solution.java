package leetcode.study.week26.ex5338;


import leetcode.study.week26.TreeNode;

/**
 * @Author : josan
 * @Date : 2020/3/7 23:42
 * @Package : leetcode.study.week26.ex5338
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLen = 0;
        int len = getLongestAtThisRoot(root);

        maxLen = Math.max(maxLen, len);
        maxLen = Math.max(maxLen, longestZigZag(root.left));
        maxLen = Math.max(maxLen, longestZigZag(root.right));
        return maxLen;
    }

    private int getLongestAtThisRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLen = 0;
        int left = longestZigZagInner(root.left, 0, true);
        int right = longestZigZagInner(root.right, 0, false);
        maxLen = Math.max(maxLen, left);
        maxLen = Math.max(maxLen, right);
        return maxLen;
    }

    private int longestZigZagInner(TreeNode root, int depth, boolean isLeft) {
        if (root == null) {
            return depth;
        }
        if (isLeft) {
            return longestZigZagInner(root.right, depth + 1, !isLeft);
        } else {
            return longestZigZagInner(root.left, depth + 1, !isLeft);
        }
    }
}
