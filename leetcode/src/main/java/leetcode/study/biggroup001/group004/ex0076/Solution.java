package leetcode.study.biggroup001.group004.ex0076;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : josan
 * @Date : 2020/2/16 20:07
 * @Package : leetcode.study.group004.ex0076
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.isEmpty()) {
            throw new IllegalArgumentException("s, t is wrong");
        }

        Map<Character, Integer> charMap = getCharMap(t);
        Map<Character, Integer> searchMap = new HashMap<>();

        int st = 0;
        int ed = 0;
        int minSt = 0;
        int minEd = 0;
        int minLen = s.length() + 1;
        boolean firstInitFlag = true;
        boolean backtrackFlag = false;
        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            if (charMap.get(ch) != null && firstInitFlag) {
                st = i;
                searchMap.put(ch, 1);
                firstInitFlag = false;
            } else if (charMap.get(ch) != null) {
                if (!backtrackFlag) {
                    searchMap.merge(ch, 1, Integer::sum);
                }  else {
                    backtrackFlag = false;
                }
            } else {
                ++i;
                continue;
            }

            if (check(searchMap, charMap)) {
                ed = i + 1;
                if (ed - st < minLen) {
                    minSt = st;
                    minEd = ed;
                    minLen = minEd - minSt;
                }
                // to get the next subject

                // remove the start
                if (searchMap.get(s.charAt(st)) == 1) {
                    searchMap.remove(s.charAt(st));
                } else {
                    searchMap.put(s.charAt(st), searchMap.get(s.charAt(st)) - 1);
                }
                st = st + 1;
                while (st < ed) {
                    if (charMap.containsKey(s.charAt(st))) {
                        break;
                    } else {
                        ++st;
                    }
                }
                backtrackFlag = true;
            } else {
                ++i;
            }
        }

        return minEd == 0 ? "" : s.substring(minSt, minEd);
    }

    private boolean check(Map<Character, Integer> searchMap, Map<Character, Integer> charMap) {
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (searchMap.get(key) == null || searchMap.get(key) < charMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getCharMap(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(s.charAt(i)) == null) {
                charMap.put(s.charAt(i), 1);
            } else {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
            }
        }
        return charMap;
    }

    private void removeChar(Map<Character, Integer> charMap, char ch) {
        if (charMap.get(ch) == 1) {
            charMap.remove(ch);
        } else {
            charMap.put(ch, charMap.get(ch) - 1);
        }
    }
}
