package leetcode.study.biggroup001.group002.ex0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/9 10:57
 * @Package : leetcode.study.group002.ex0040
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        checkParams(candidates, target);

        if (target <= 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0 , 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int target, int st, int sum,
                     List<Integer> list, List<List<Integer>> result) {
        if (sum < target) {
            for (int i = st; i < candidates.length; i++) {
                // 剪枝
                if (sum + candidates[i] > target) {
                    break;
                }
                list.add(candidates[i]);
                dfs(candidates, target, i + 1, sum + candidates[i],
                        list, result);
                list.remove(list.size() - 1);
                if (list.isEmpty()) {
                    int j = i;
                    while (j < candidates.length &&
                            candidates[j] == candidates[i]) {
                        ++j;
                    }
                    i = j - 1;
                }
            }
        } else if (sum == target) {
            List<Integer> tmp = new ArrayList<>(list);
            if (!result.contains(tmp)) {
                result.add(tmp);
            }
        }
    }

    private void checkParams(int[] candidates, int target) {
        if (candidates == null) {
            throw new IllegalArgumentException("candidates is null");
        }
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= 0) {
                throw new IllegalArgumentException("candidates element is error");
            }
        }
    }
}
