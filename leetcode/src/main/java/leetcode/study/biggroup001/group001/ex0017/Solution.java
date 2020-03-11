package leetcode.study.biggroup001.group001.ex0017;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author : josan
 * @Date : 2020/2/6 13:23
 * @Package : leetcode.study.group001.ex0017
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        return letterCombinations(digits, 0, digits.length(), map);
    }

    private List<String> letterCombinations(String digits, int st, int ed,
                                            Map<Character, List<Character>> map) {
        if (ed - st < 1) {
            return new ArrayList<>();
        } else if (ed - st == 1) {
            return map.get(digits.charAt(st))
                    .stream()
                    .map(c -> c.toString())
                    .collect(Collectors.toList());
        }

        List<String> result = new ArrayList<>();
        List<String> tailList = letterCombinations(digits, st + 1, ed, map);
        List<Character> characterList = map.get(digits.charAt(st));
        for (Character ch : characterList) {
            for (String str : tailList) {
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                sb.append(str);
                result.add(sb.toString());
            }
        }
        return result;
    }
}
