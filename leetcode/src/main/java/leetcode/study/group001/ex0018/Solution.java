package leetcode.study.group001.ex0018;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/6 13:56
 * @Package : leetcode.study.group001.ex0018
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
//            throw new IllegalArgumentException("nums is wrong");
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ) {
            for (int j = i + 1; j < nums.length - 2; ) {
                List<List<Integer>> tempList = twoSum(nums, j + 1, (long)target - nums[i] - nums[j]);
                for (List<Integer> temp : tempList) {
                    result.add(Arrays.asList(nums[i], nums[j], temp.get(0), temp.get(1)));
                }
                j = nextPos(nums, j);
            }
            i = nextPos(nums, i);
        }
        return result;
    }

    private int nextPos(int[] nums, int st) {
        int cur = st + 1;
        while (cur < nums.length && nums[st] == nums[cur]) {
            ++cur;
        }
        return cur;
    }

    private int prevPos(int[] nums, int ed) {
        int cur = ed - 1;
        while (cur >= 0 && nums[ed] == nums[cur]) {
            --cur;
        }
        return cur;
    }

    private List<List<Integer>> twoSum(int[] nums, int st, long target) {
        List<List<Integer>> result = new ArrayList<>();

        int ed = nums.length - 1;
        while (st < ed) {
            if ((long)nums[st] + nums[ed] == target) {
                result.add(Arrays.asList(nums[st], nums[ed]));
                st = nextPos(nums, st);
                ed = prevPos(nums, ed);
            } else if ((long)nums[st] + nums[ed] < target) {
                st = nextPos(nums, st);
            } else {
                ed = prevPos(nums, ed);
            }
        }

        return result;
    }
}
