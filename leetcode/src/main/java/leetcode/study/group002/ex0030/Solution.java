package leetcode.study.group002.ex0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author : josan
 * @Date : 2020/2/7 11:00
 * @Package : leetcode.study.group002.ex0030
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        Integer wordsLen = words[0].length() * words.length;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - wordsLen + 1; i++) {
            String subString = s.substring(i, i + wordsLen);
            Map<String, Integer> wordMapTmp = new HashMap<>(wordMap);
            if (isValid(subString, wordMapTmp, words[0].length())) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isValid(String s, Map<String, Integer> wordMap, int wordLen) {
        int st = 0;
        while (st < s.length()) {
            String subString = s.substring(st, st + wordLen);
            if (wordMap.containsKey(subString) && wordMap.get(subString) > 0) {
                wordMap.put(subString, wordMap.get(subString) - 1);
                st += wordLen;
            } else {
                break;
            }
        }

        return !(st < s.length());
    }

    // 超时02
    public List<Integer> findSubstringNotPass02(String s, String[] words) {
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            String word = entry.getKey();
            Map<String, Integer> wordMapTmp = new HashMap<>(wordMap);
            wordMapTmp.put(word, wordMapTmp.get(word) - 1);

            int pos = s.indexOf(word, 0);
            while (pos != -1) {
                // result.contains(pos) to delete the duplicate result
                if (!result.contains(pos)
                        && isValid(s, pos + word.length(), wordMapTmp)) {
                    result.add(pos);
                }
                pos = s.indexOf(word, pos + 1);
            }
        }

        return result.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean isValid(String s, int st, Map<String, Integer> wordMap) {
        boolean result = true;
        for (Integer value : wordMap.values()) {
            if (value != 0) {
                result = false;
                break;
            }
        }
        if (result) {
            return true;
        }

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            String word = entry.getKey();
            Map<String, Integer> wordMapTmp = new HashMap<>(wordMap);
            wordMapTmp.put(word, wordMapTmp.get(word) - 1);

            int pos = s.indexOf(word, st);
            if (pos == st) {
                return isValid(s, st + word.length(), wordMapTmp);
            }
        }
        return false;
    }

    // 超时
    public List<Integer> findSubstringNotPass(String s, String[] words) {
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            List<String> wordList = Stream.of(words)
                    .collect(Collectors.toList());
            wordList.remove(i);
            int pos = s.indexOf(words[i], 0);
            while (pos != -1) {
                // result.contains(pos) to delete the duplicate result
                if (!result.contains(pos)
                        && isValid(s, pos + words[i].length(), wordList)) {
                    result.add(pos);
                }
//                pos = s.indexOf(words[i], pos + words[i].length());  // wrong
                pos = s.indexOf(words[i], pos + 1);
            }
        }

        return result.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean isValid(String s, int st, List<String> wordList) {
        if (wordList.isEmpty()) {
            return true;
        }
        int wordListLen = wordList.get(0).length() * wordList.size();
        int remainLen = s.length() - st;
        if (remainLen < wordListLen) {
            return false;
        }

        for (int i = 0; i < wordList.size(); i++) {
            List<String> tempWordList = new ArrayList<>(wordList);
            tempWordList.remove(i);
            int pos = s.indexOf(wordList.get(i), st);
            if (pos == st) {
                return isValid(s, st + wordList.get(0).length(), tempWordList);
            }
        }
        return false;
    }
}
