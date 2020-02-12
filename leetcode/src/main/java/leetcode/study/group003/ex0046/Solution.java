package leetcode.study.group003.ex0046;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/10 0:47
 * @Package : leetcode.study.group003.ex0046
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        permuteInner(nums, isVisited, 0, result, currentList);
        return result;
    }

    private void permuteInner(int[] nums, boolean[] isVisited, int st, List<List<Integer>> result, List<Integer> currentList) {
        if (currentList.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(currentList);
            result.add(temp);
            return ;
        }
        for (int i = st; i < st + nums.length; i++) {
            int fixedI = i % nums.length;
            if (!isVisited[fixedI]) {
                currentList.add(nums[fixedI]);
                isVisited[fixedI] = true;
                permuteInner(nums, isVisited, (fixedI + 1) % nums.length, result, currentList);
                currentList.remove(currentList.size() - 1);
                isVisited[fixedI] = false;
            }
        }
    }
}