package leetcode.study.group003.ex0043;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : josan
 * @Date : 2020/2/9 17:17
 * @Package : leetcode.study.group003.ex0043
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("num1 or num2 is null");
        }

        if (num1.equals("0")) {
            return "0";
        }

        Map<Character, String> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            char ch = (char)('0' + i);
            hashMap.put(ch, multiplySingleNumber(num1, i));
        }

        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            char ch = num2.charAt(i);
            StringBuilder sb = new StringBuilder();
            sb.append(hashMap.get(ch));
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append("0");
            }
            result = addString(result, sb.toString());
        }
        return result;
    }

    private String multiplySingleNumber(String str, int num) {
        if (num == 0) {
            return "0";
        } else if (num == 1) {
            return str;
        }

        int i = str.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || carry > 0) {
            int leftNum = i >= 0 ? str.charAt(i) - '0' : 0;
            int value = (leftNum * num + carry) % 10;
            carry = (leftNum * num + carry) / 10;
            sb.append((char)(value + '0'));

            i = i >= 0 ? --i : i;
        }
        return revertStr(sb.toString());
    }

    private String addString(String lhs, String rhs) {
        int i = lhs.length() - 1;
        int j = rhs.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int leftNum = i >= 0 ? lhs.charAt(i) - '0' : 0;
            int rightNum = j >= 0 ? rhs.charAt(j) - '0' : 0;
            int value = (leftNum + rightNum + carry) % 10;
            carry = (leftNum + rightNum + carry) / 10;
            sb.append((char)(value + '0'));

            i = i >= 0 ? --i : i;
            j = j >= 0 ? --j : j;
        }
        return revertStr(sb.toString());
    }

    private String revertStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; --i) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
