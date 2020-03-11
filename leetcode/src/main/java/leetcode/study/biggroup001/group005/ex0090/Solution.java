package leetcode.study.biggroup001.group005.ex0090;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/3/7 0:07
 * @Package : leetcode.study.group005.ex0090
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums is null");
        }

        List<Integer> tmpList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsetWithDupInner(nums, 0, tmpList, result);
        return result;
    }

    private void subsetWithDupInner(int[] nums, int st,
                                    List<Integer> tmpList,
                                    List<List<Integer>> result) {
        if (st == nums.length) {
            List<Integer> tmp = new ArrayList<>(tmpList);
            tmp.sort(Comparator.comparingInt(a -> a));
            if (!result.contains(tmp)) {
                result.add(tmp);
            }
            return ;
        }

        if (st < nums.length) {
            subsetWithDupInner(nums, st + 1, tmpList, result);
            tmpList.add(nums[st]);
            subsetWithDupInner(nums, st + 1, tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
