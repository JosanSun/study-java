package leetcode.study.biggroup001.group001.ex0013;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : josan
 * @Date : 2020/2/5 21:41
 * @Package : leetcode.study.group001.ex0013
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            int value = 0;
            if (s.charAt(i) == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    value = 4;
                    ++i;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    value = 9;
                    ++i;
                } else {
                    value = 1;
                }
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    value = 40;
                    ++i;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    value = 90;
                    ++i;
                } else {
                    value = 10;
                }
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    value = 400;
                    ++i;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    value = 900;
                    ++i;
                } else {
                    value = 100;
                }
            } else {
                value = hashMap.get(s.charAt(i));
            }
            sum += value;
        }
        return sum;
    }
}
