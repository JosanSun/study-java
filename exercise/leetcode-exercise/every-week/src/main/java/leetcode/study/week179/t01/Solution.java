package leetcode.study.week179.t01;

/**
 * @Author : josan
 * @Date : 2020/3/8 10:20
 * @Package : leetcode.study.week179.t01
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public String generateTheString(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n is wrong");
        }

        StringBuilder sb =  new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        } else {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }

        return sb.toString();
    }
}
