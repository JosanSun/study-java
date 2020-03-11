package leetcode.study.biggroup001.group002.ex0022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/6 16:50
 * @Package : leetcode.study.group002.ex0022
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generateParenthesis(c)) {
                    for (String right : generateParenthesis(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }

    public List<String> generateParenthesis02(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String cur, int leftNum, int rightNum, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (leftNum < max) {
            backtrack(ans, cur + "(", leftNum + 1, rightNum, max);
        }
        if (rightNum < leftNum) {
            backtrack(ans, cur + ")", leftNum, rightNum + 1, max);
        }
    }



    public List<String> generateParenthesisOrigin(int n) {
        return generateParenthesisOrigin(n, 0, 0);
    }

    private List<String> generateParenthesisOrigin(int n, int leftNum, int right) {
        if (leftNum > n || right > n || right > leftNum) {
            return new ArrayList<>();
        }

        if (leftNum == right && leftNum == n) {
            return Arrays.asList("");
        }

        List<String> result = new ArrayList<>();
        List<String> tempList = generateParenthesisOrigin(n, leftNum + 1, right);
        for (String temp : tempList) {
            StringBuilder sb = new StringBuilder();
            sb.append(temp);
            sb.append(')');
            result.add(sb.toString());
        }
        List<String> tempList2 = generateParenthesisOrigin(n, leftNum, right + 1);
        for (String temp : tempList2) {
            StringBuilder sb = new StringBuilder();
            sb.append(temp);
            sb.append('(');
            result.add(sb.toString());
        }
        return result;
    }
}
