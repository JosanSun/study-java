package leetcode.study.biggroup001.group005.ex0099;

import leetcode.study.common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/3/7 21:24
 * @Package : leetcode.study.group005.ex0099
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return ;
        }
        List<Integer> numList = new ArrayList<>();
        getNodeValues(root, numList);
        numList.sort(Comparator.comparingInt(a -> a));
        inOrderTraverse(root, numList);
    }

    private void inOrderTraverse(TreeNode root, List<Integer> numList) {
        if (root != null) {
            inOrderTraverse(root.left, numList);
            root.val = numList.get(0);
            numList.remove(0);
            inOrderTraverse(root.right, numList);
        }
    }

    private void getNodeValues(TreeNode root, List<Integer> numList) {
        if (root != null) {
            numList.add(root.val);

            getNodeValues(root.left, numList);
            getNodeValues(root.right, numList);
        }
    }
}
