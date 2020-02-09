package leetcode.study.group002.ex0039;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/9 9:17
 * @Package : leetcode.study.group002.ex0039
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        checkParams(candidates, target);

        if (target <= 0) {
            return new ArrayList<>();
        }

        List<Integer> fixedCandidates = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j < target / candidates[i]; j++) {
                fixedCandidates.add(candidates[i]);
            }
        }
        fixedCandidates.sort(Comparator.comparingInt(a -> a));
        List<List<Integer>> result = new ArrayList<>();
         dfs(fixedCandidates, target, 0 , 0, new ArrayList<>(), result);
         return result;
    }

    private void dfs(List<Integer> candidates, int target, int st, int sum,
                        List<Integer> list, List<List<Integer>> result) {
        if (sum < target) {
            for (int i = st; i < candidates.size(); i++) {
                // 剪枝
                if (sum + candidates.get(i) > target) {
                    break;
                }
                list.add(candidates.get(i));
                dfs(candidates, target, i + 1, sum + candidates.get(i),
                        list, result);
                list.remove(list.size() - 1);
                if (list.isEmpty()) {
                    int j = i;
                    while (j < candidates.size() &&
                            candidates.get(j).equals(candidates.get(i))) {
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