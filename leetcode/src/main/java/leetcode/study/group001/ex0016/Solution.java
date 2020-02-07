package leetcode.study.group001.ex0016;

import java.util.Arrays;

/**
 * @Author : josan
 * @Date : 2020/2/6 13:03
 * @Package : leetcode.study.group001.ex0016
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("nums is wrong");
        }

        Arrays.sort(nums);
        int nearest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; ) {
            int st = i + 1;
            int ed = nums.length - 1;
            while (st < ed) {
                int sum = nums[i] + nums[st] + nums[ed];
                if (sum == target) {
                    return target;
                } else {
                    if (Math.abs(target - sum) < Math.abs(target - nearest)) {
                        nearest = sum;
                    }
                    if (sum < target) {
                        st = nextPos(nums, st);
                    } else {
                        ed = prevPos(nums, ed);
                    }
                }
            }
            i = nextPos(nums, i);
        }
        return nearest;
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
}