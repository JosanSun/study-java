package leetcode.study.biggroup001.group001.ex0015;

import java.util.*;

/**
 * @Author : josan
 * @Date : 2020/2/5 22:30
 * @Package : leetcode.study.group001.ex0015
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> allIdxRes = new ArrayList<>();
        for (int i = 0; i < nums.length - 2;) {
            List<List<Integer>> result = twoSum(nums, i + 1, -nums[i]);
            if (!result.isEmpty()) {
                for (List<Integer> resultIdxList : result) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(resultIdxList.get(0));
                    temp.add(resultIdxList.get(1));
                    if (!allIdxRes.contains(temp)) {
                        allIdxRes.add(temp);
                    }
                }
            }
            i = nextPos(nums, i);
        }
        return allIdxRes;
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

    private List<List<Integer>> twoSum(int[] nums, int st, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int ed = nums.length - 1;

        while(st < ed) {
            if (nums[st] + nums[ed] == target) {
                List<Integer> temp = new ArrayList<>(2);
                temp.add(nums[st]);
                temp.add(nums[ed]);
                if (!result.contains(temp)) {
                    result.add(temp);
                }
                st = nextPos(nums, st);
                ed = prevPos(nums, ed);
            } else if (nums[st] + nums[ed] < target) {
                st = nextPos(nums, st);
            } else if (nums[st] + nums[ed] > target) {
                ed = prevPos(nums, ed);
            }
        }

        return result;
    }

    public List<List<Integer>> threeSumNot(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> allIdxRes = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> result = twoSum(nums, i + 1, -nums[i]);
            if (!result.isEmpty()) {
                for (List<Integer> resultIdxList : result) {
                    List<Integer> temp = new ArrayList<>();
                    int a = Integer.min(Integer.min(nums[i],
                            nums[resultIdxList.get(0)]), nums[resultIdxList.get(1)]);
                    int c = Integer.max(Integer.max(nums[i],
                            nums[resultIdxList.get(0)]), nums[resultIdxList.get(1)]);
                    int b = nums[i] + nums[resultIdxList.get(0)] + nums[resultIdxList.get(1)]
                            - a - c;
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    if (!allIdxRes.contains(temp)) {
                        allIdxRes.add(temp);
                    }
                }
            }
        }

        return allIdxRes;
    }

    private List<List<Integer>> twoSumNotPass(int[] nums, int st, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(nums[st], st);
        int nextPos = st + 1;
        while (nextPos < nums.length) {
            if (map.containsKey(target - nums[nextPos])) {
                List<Integer> temp = new ArrayList<>(2);
                temp.add(map.get(target - nums[nextPos]));
                temp.add(nextPos);
                result.add(temp);
            }
            map.put(nums[nextPos], nextPos);
            ++ nextPos;
        }
        return result;
    }
}
