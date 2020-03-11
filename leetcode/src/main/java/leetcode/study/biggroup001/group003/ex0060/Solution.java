package leetcode.study.biggroup001.group003.ex0060;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/12 23:22
 * @Package : leetcode.study.group003.ex0060
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public String getPermutation(int n, int k) {
        if (n < 0 || n > 9 || k < 1) {
            throw new IllegalArgumentException("n, k is wrong");
        }
        List<Integer> numList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numList.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();

        getPermutationInner(n, k, numList, 0, sb);
        return sb.toString();
    }

    private void getPermutationInner(int n, int k, List<Integer> numList, int st,
                                      StringBuilder sb) {
        if (st == n) {
            return ;
        }

        int factor = factorial(n - st - 1);
        int idx = (k - 1) / factor;
        sb.append(numList.get(idx));
        numList.remove(idx);

        k = k - idx * factor;
        getPermutationInner(n, k, numList, ++st, sb);
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }


}
