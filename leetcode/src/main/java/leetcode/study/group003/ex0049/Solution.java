package leetcode.study.group003.ex0049;

import java.util.*;

/**
 * @Author : josan
 * @Date : 2020/2/10 22:32
 * @Package : leetcode.study.group003.ex0049
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException("strs is null");
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (map.get(str.length()) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(str.length(), list);
            } else {
                List<Integer> list = map.get(str.length());
                list.add(i);
                map.put(str.length(), list);
            }
        }
        Map<String, Map<Character, Integer>> strHelperMap = generateHelperMap(strs);


        List<List<String>> result = new ArrayList<>();
        for(List<Integer> value : map.values()) {
            List<List<String>> tmp = getGroupAnagrams(strs, value, strHelperMap);
            result.addAll(tmp);
        }
        return result;
    }

    private Map<String, Map<Character, Integer>> generateHelperMap(String[] strs) {
        Map<String, Map<Character, Integer>> strHelperMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            strHelperMap.put(strs[i], generateStrMap(strs[i]));
        }
        return strHelperMap;
    }

    private Map<Character, Integer> generateStrMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        return map;
    }

    private List<List<String>> getGroupAnagrams(String[] strs, List<Integer> idxList,
                                                Map<String, Map<Character, Integer>> strHelperMap) {
        List<List<String>> result = new ArrayList<>();
        for (Integer idx : idxList) {
            int i = 0;
            for (; i < result.size(); i++) {
                if (isGroup(strs[idx], result.get(i).get(0), strHelperMap)) {
                    break;
                }
            }
            if (i < result.size()) {
                List<String> tmp = result.get(i);
                tmp.add(strs[idx]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[idx]);
                result.add(tmp);
            }
        }
        return result;
    }

    /***
     * str1.length must equal to str2.length
     * @param str1
     * @param str2
     * @param strHelperMap
     * @return
     */
    private boolean isGroup(String str1, String str2,
                            Map<String, Map<Character, Integer>> strHelperMap) {
        Map<Character, Integer> map1 = strHelperMap.get(str1);
        Map<Character, Integer> map2 = strHelperMap.get(str2);
        boolean isGroup = true;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.get(entry.getKey()) == null
                || !Objects.equals(map2.get(entry.getKey()), entry.getValue())) {
                isGroup = false;
                break;
            }
        }
        return isGroup;
    }
}
