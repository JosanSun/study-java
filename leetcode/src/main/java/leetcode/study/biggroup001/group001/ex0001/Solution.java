package leetcode.study.biggroup001.group001.ex0001;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
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

    public int[] twoSumOrigin(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        List<NumWithIdx> sortedNums = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; ++i) {
            NumWithIdx numWithIdx = new NumWithIdx(nums[i], i);
            sortedNums.add(numWithIdx);
        }

        sortedNums = sortedNums.stream()
                .sorted(Comparator.comparingInt(NumWithIdx::getValue))
                .collect(Collectors.toList());
        int st = 0;
        int ed = nums.length - 1;
        while(st < ed) {
            if (sortedNums.get(st).getValue() + sortedNums.get(ed).getValue() == target) {
                return returnRes(sortedNums.get(st).getIdx(),
                        sortedNums.get(ed).getIdx());
            }

            if (sortedNums.get(st).getValue() + sortedNums.get(ed).getValue() < target) {
                ++st;
            } else {
                --ed;
            }
        }

        return null;
    }

    private int[] returnRes(Integer a, Integer b) {
        int[] result = {a, b};
        if (a >= b) {
            result[0] = b;
            result[1] = a;
        }
        return result;
    }
}

class NumWithIdx {
    Integer value;
    Integer idex;

    public NumWithIdx() {
    }

    public NumWithIdx(Integer value, Integer idex) {
        this.value = value;
        this.idex = idex;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getIdx() {
        return idex;
    }

    public void setIdex(Integer idex) {
        this.idex = idex;
    }
}
