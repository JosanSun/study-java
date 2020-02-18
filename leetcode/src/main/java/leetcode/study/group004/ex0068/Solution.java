package leetcode.study.group004.ex0068;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/16 11:50
 * @Package : leetcode.study.group004.ex0068
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException("words is wrong");
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            int st = i;
            int ed = i + 1;
            // 因为可能出现一个字符串的大小，刚好等于maxWidth, 为了与后面totalLength += (words[j].length() + 1); 一致
            // 故赋值为-1
            int totalLength = -1;

            int j = st;
            for ( ; j < words.length; ++j) {
                // +1  加的是一个空格
                totalLength += (words[j].length() + 1);
                if (totalLength > maxWidth) {
                    break;
                }
            }
            ed = j;
            String rowString = j >= words.length ? getRowString(words, st, ed, maxWidth, true)
                    : getRowString(words, st, ed, maxWidth, false);
            result.add(rowString);
            i = ed;
        }

        return result;
    }

    /***
     * 找到每一行的输出
     * @param words
     * @param st
     * @param ed
     * @param maxWidth
     * @param isLastRow
     * @return
     */
    private String getRowString(String[] words, int st, int ed, int maxWidth, boolean isLastRow) {
        StringBuilder sb = new StringBuilder();
        if (isLastRow) {
            for (int i = st; i < ed; i++) {
                if (i != st) {
                    sb.append(" ");
                }
                sb.append(words[i]);
            }
            appendNSpace(sb, maxWidth - sb.length());
        } else {
            int totalLength = 0;
            for (int i = st; i < ed; i++) {
                totalLength += words[i].length();
            }
            int remainLength = maxWidth - totalLength;
            int spaceNumber = ed - st - 1;
            if (spaceNumber == 0) {
                sb.append(words[st]);
                appendNSpace(sb, remainLength);
            } else {
                int baseSpaceNumber = remainLength / spaceNumber;
                int addedNumber = remainLength % spaceNumber;

                for (int i = st; i < ed; i++) {
                    sb.append(words[i]);
                    if (i != ed - 1) {
                        if (addedNumber > 0) {
                            appendNSpace(sb, baseSpaceNumber + 1);
                            --addedNumber;
                        } else {
                            appendNSpace(sb, baseSpaceNumber);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    private void appendNSpace(StringBuilder sb, int len) {
        for (int i = 0; i < len; i++) {
            sb.append(" ");
        }
    }
}
