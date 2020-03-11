package leetcode.study.week26;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : josan
 * @Date : 2020/3/7 14:47
 * @Package : leetcode.study.equal.util
 * @ProjectName: pom-parent
 * @Description:
 */
public class TreeNodeHelper {
    public static void assertEqualNode(TreeNode lhs, TreeNode rhs) {
        boolean isSame = assertEqualNodeInner(lhs, rhs);
        if (isSame) {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }
    }

    private static boolean assertEqualNodeInner(TreeNode lhs, TreeNode rhs) {
        boolean result = false;
        if (lhs == null && rhs == null) {
            return true;
        } else if (lhs == null || rhs == null) {
            return false;
        } else {
            if (lhs.val == rhs.val) {
                result = assertEqualNodeInner(lhs.left, rhs.left)
                        && assertEqualNodeInner(lhs.right, rhs.right);
            } else {
                return false;
            }
        }
        return result;
    }

    public static TreeNode createTreeNodeFromList(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return new TreeNode(-1);
        }

        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> queue = new LinkedList<>();

        if (nums.get(0) != null) {
            root = new TreeNode(nums.get(0));
            queue.add(root);
        } else {
            return null;
        }

        int i = 0;
        while (!queue.isEmpty() && i < nums.size()) {
            TreeNode node = queue.poll();
            if ((i + 1) < nums.size() && nums.get(++i) != null) {
                node.left = new TreeNode(nums.get(i));
                queue.offer(node.left);
            }
            if ((i + 1) < nums.size() && nums.get(++i) != null) {
                node.right = new TreeNode(nums.get(i));
                queue.offer(node.right);
            }
        }
        return root;
    }

    private static int createTreeNodeFromListInner(TreeNode node, List<Integer> nums, int st) {
        if (nums.size() <= st) {
            return st;
        }
        if (nums.get(st) == null) {
            return st + 1;
        } else {
            node.val = nums.get(st);
            if (st + 1 < nums.size() && nums.get(st + 1) != null) {
                TreeNode leftNode = new TreeNode(nums.get(st + 1));
                node.left = leftNode;
                st = createTreeNodeFromListInner(node, nums, st + 1);
            } else {
                ++st;
            }

            if (st + 1 < nums.size() && nums.get(st + 1) != null) {
                TreeNode rightNode = new TreeNode(nums.get(st + 1));
                node.right = rightNode;
                st = createTreeNodeFromListInner(node, nums, st + 1);
            } else {
                ++st;
            }
        }
        return st;
    }
}
