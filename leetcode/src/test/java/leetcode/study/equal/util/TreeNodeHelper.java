package leetcode.study.equal.util;

import leetcode.study.common.TreeNode;

import java.util.*;

/**
 * @Author : josan
 * @Date : 2020/3/7 14:47
 * @Package : leetcode.study.equal.util
 * @ProjectName: pom-parent
 * @Description:
 */
public class TreeNodeHelper {
    public static void assertEqualArrayNode(List<TreeNode> expected, List<TreeNode> result) {
        boolean isSame = assertEqualArrayNodeInner(expected, result);
        if (isSame) {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }
    }

    private static boolean assertEqualArrayNodeInner(List<TreeNode> expected, List<TreeNode> result) {
        if (expected == null && result == null) {
            return true;
        } else if (expected == null || result == null) {
            return false;
        }
        if (expected.size() != result.size()) {
            return false;
        }
        // 开始比较size
        if (expected.isEmpty()) {
            return true;
        }

        boolean[] isUsed = new boolean[expected.size()];
        for (int i = 0; i < result.size(); i++) {
            boolean isAnyMath = false;
            for (int j = 0; j < expected.size(); j++) {
                if (!isUsed[j] && assertEqualNodeInner(result.get(i), result.get(j))) {
                    isUsed[j] = true;
                    isAnyMath = true;
                    break;
                }
            }
            if (!isAnyMath) {
                return false;
            }
        }

        for (boolean flag : isUsed) {
            if (!flag) {
                return false;
            }
        }

        return true;
    }

    private static Map<Integer, List<TreeNode>> createMapRootTree(List<TreeNode> list) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        for (TreeNode node : list) {
            if (map.get(node.val) == null) {
                List<TreeNode> nodeList = new ArrayList<>();
                nodeList.add(node);
                map.put(node.val, nodeList);
            } else {
                map.get(node.val).add(node);
            }
        }
        return map;
    }

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
