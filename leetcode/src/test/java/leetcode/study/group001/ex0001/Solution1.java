package leetcode.study.group001.ex0001;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(target - value)) {
                return new int[]{map.get(target - value), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
