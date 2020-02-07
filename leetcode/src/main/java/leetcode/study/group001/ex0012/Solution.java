package leetcode.study.group001.ex0012;

/**
 * @Author : josan
 * @Date : 2020/2/5 21:12
 * @Package : leetcode.study.group001.ex0012
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("num is error");
        }

        String[][] numRoman = new String[][]
                {
                        {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                        {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                        {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                        {"", "M", "MM", "MMM"}
                };

        int pos = 0;
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            String end = numRoman[pos++][num % 10];
            num /= 10;
            result.insert(0, end);
        }
        return result.toString();
    }
}
