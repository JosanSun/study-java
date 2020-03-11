package leetcode.study.biggroup001.group004.ex0078;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/18 0:59
 * @Package : leetcode.study.group004.ex0078
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums is null");
        }

        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        subsetsInner(nums, 0, prev, result);
        return result;
    }

    private void subsetsInner(int[] nums, int st, List<Integer> prev, List<List<Integer>> result) {
        if (st >= nums.length) {
            result.add(new ArrayList<>(prev));
            return ;
        }

        // 不插入
        subsetsInner(nums, st + 1, prev, result);

        // 插入值
        prev.add(nums[st]);
        subsetsInner(nums, st + 1, prev, result);
        prev.remove(prev.size() - 1);
    }
}
