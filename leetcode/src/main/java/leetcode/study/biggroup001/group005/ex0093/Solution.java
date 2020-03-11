package leetcode.study.biggroup001.group005.ex0093;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : josan
 * @Date : 2020/3/7 13:56
 * @Package : leetcode.study.group005.ex0093
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null ) {
            throw new IllegalArgumentException("s is null");
        }
        if (s.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        restoreIpAddressesInner(s.toCharArray(), 0, tmp, result);
        return convert(result);
    }

    private void restoreIpAddressesInner(char[] chars, int st, List<Integer> tmp,
                                    List<List<Integer>> result) {
        if (st == chars.length && tmp.size() == 4) {
            result.add(new ArrayList<>(tmp));
            return ;
        }

        int n = 4;
        int remainChars = chars.length - st;
        int remainInteger = n - tmp.size();

        if (remainChars > remainInteger * 3 || remainChars < remainInteger) {
            return ;
        }

        for (int i = 0; i < 3; i++) {
            if (st + i < chars.length) {
                int value = convertChars2Int(chars, st, st + i + 1);
                if (value <= 255 && chars[st] != '0'
                    || (i == 0 && chars[st] == '0')) {
                    tmp.add(value);
                    restoreIpAddressesInner(chars, st + i + 1, tmp, result);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private Integer convertChars2Int(char[] chars, int st, int ed) {
        int sum = 0;
        int i = st;
        while (i < ed) {
            sum = sum * 10 + (chars[i] - '0');
            ++i;
        }
        return sum;
    }

    private List<String> convert(List<List<Integer>> result) {
        if (result == null || result.isEmpty()) {
            return new ArrayList<>();
        }

        return result.stream()
                .map(this::map2String)
                .collect(Collectors.toList());
    }

    private String map2String(List<Integer> list) {
        List<String> result =
                list.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        return String.join(".", result);
    }
}