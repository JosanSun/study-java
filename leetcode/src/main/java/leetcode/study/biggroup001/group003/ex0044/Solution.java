package leetcode.study.biggroup001.group003.ex0044;

/**
 * @Author : josan
 * @Date : 2020/2/9 17:53
 * @Package : leetcode.study.group003.ex0044
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        String fixPattern = fixed(p);

        int m = s.length();
        int n = fixPattern.length();

        boolean[][] flag = new boolean[m + 1][n + 1];

        flag[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            flag[0][i] = flag[0][i -1] && fixPattern.charAt(i - 1) == '*';
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (fixPattern.charAt(j - 1) == '?'
                        || fixPattern.charAt(j - 1) == s.charAt(i - 1)) {
                    flag[i][j] = flag[i - 1][j - 1];
                } else if (fixPattern.charAt(j - 1) == '*') {
                    flag[i][j] = flag[i][j - 1] || flag[i - 1][j];
                }
            }
        }

        return flag[m][n];
    }

    public boolean isMatchNotPass02(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        String fixPattern = fixed(p);

        return isMatchInnerNotPass02(s, 0, fixPattern, 0);
    }

    private String fixed(String p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                sb.append(p.charAt(i));
            } else {
                sb.append('*');
                int j = i;
                while (j < p.length() && p.charAt(j) == '*') {
                    ++j;
                }
                i = j - 1;
            }
        }
        return sb.toString();
    }

    private boolean isMatchInnerNotPass02(String s, int st1, String p, int st2) {
        if (st2 == p.length()) {
            return st1 == s.length();
        }
        if (st1 == s.length()) {
            while (st2 < p.length() && p.charAt(st2) == '*') {
                ++st2;
            }
            return st2 == p.length();
        }
        // 剪枝
        int validNums = 0;
        for (int i = st2; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                ++validNums;
            }
        }
        if (validNums > s.length() - st1) {
            return false;
        }

        if (p.charAt(st2) != '*') {
            int nextPos = p.indexOf("*", st2);
            nextPos = nextPos == -1 ? p.length() : nextPos;
            String tempPatter = p.substring(st2, nextPos);
            if(matchNoAsteriskIndex(s, st1, tempPatter) == st1) {
                return isMatchInnerNotPass02(s, st1 + tempPatter.length(), p, st2 + tempPatter.length());
            } else {
                return false;
            }
        } else {
            if (st2 + 1 >= p.length()) {
                return true;
            }
            int nextPos = p.indexOf("*", st2 + 1);
            nextPos = nextPos == -1 ? p.length() : nextPos;
            String tempPatter = p.substring(st2 + 1, nextPos);
            int indexPos = matchNoAsteriskIndex(s, st1, tempPatter);
            boolean result = false;
            while (indexPos != -1) {
                result = result || isMatchInnerNotPass02(s, indexPos + tempPatter.length(), p, nextPos);
                if (result) {
                    break;
                }
                indexPos = matchNoAsteriskIndex(s, indexPos + 1, tempPatter);
            }
            return result;
        }
    }

    private int matchNoAsteriskIndex(String s, int st, String p) {
        for (int i = st; i < s.length() - p.length() + 1; i++) {
            int j = 0;
            while (j < p.length()) {
                if (p.charAt(j) == '?' || s.charAt(i + j) == p.charAt(j)) {
                    ++j;
                } else {
                    break;
                }
            }
            if (j >= p.length()){
                return i;
            }
        }
        return -1;
    }

    public boolean isMatchNotPass(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return isMatchInnerNotPass(s, 0, p, 0);
    }

    private boolean isMatchInnerNotPass(String s, int st1, String p, int st2) {
        if (st2 == p.length()) {
            return st1 == s.length();
        }
        if (st1 == s.length()) {
            while (st2 < p.length() && p.charAt(st2) == '*') {
                ++st2;
            }
            return st2 == p.length();
        }

        if (p.charAt(st2) != '*') {
            if (s.length() - st1 <= 0) {
                return false;
            } else {
                return (p.charAt(st2) == '?' || s.charAt(st1) == p.charAt(st2))
                        && isMatchInnerNotPass(s, st1 + 1, p, st2 + 1);
            }
        } else {
            boolean result = false;
            for (int i = st1; i <= s.length(); i++) {
                boolean resultTmp = isMatchInnerNotPass(s, i, p, st2 + 1);
                result = resultTmp || result;
            }
            return result;
        }
    }
}
