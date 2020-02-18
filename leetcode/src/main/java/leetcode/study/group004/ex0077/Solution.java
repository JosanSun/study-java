package leetcode.study.group004.ex0077;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author : josan
 * @Date : 2020/2/16 21:21
 * @Package : leetcode.study.group004.ex0077
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k < 0 || k > n) {
            throw new IllegalArgumentException("n or k is wrong");
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        combineInner(n, k, 1, tmpList, result);
        return result;
    }

    private void combineInner(int n, int k, int st, List<Integer> tmpList,
                              List<List<Integer>> result) {
        if (tmpList.size() == k) {
            result.add(new ArrayList<>(tmpList));
            return ;
        }

        for (int i = st; i <= n - k + tmpList.size() + 1; i++) {
            tmpList.add(i);
            combineInner(n, k, i + 1, tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }

    }
}
