package leetcode.study.biggroup001.group005.ex0089;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/3/6 23:48
 * @Package : leetcode.study.group005.ex0089
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        if (n < 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        System.out.println(res.get(0));

        return grayCodeInner(n);
    }

    private List<Integer> grayCodeInner(int n) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(0));
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> resultTmp = grayCodeInner(n - 1);

        resultTmp.forEach(e -> result.add(e << 1));

        for (int i = resultTmp.size() - 1; i >= 0; i--) {
            result.add((resultTmp.get(i) << 1) + 1);
        }
        return result;
    }
}
