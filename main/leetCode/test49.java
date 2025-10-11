package leetCode;

import java.util.*;

public class test49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 获取字符串的排序键
            String key = getSortedString(str);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            // 对每组内的字符串排序
            group.sort(String::compareTo);
            result.add(group);
        }

        // 按组大小排序
        result.sort(Comparator.comparingInt(List::size));
        return result;
    }

    private static String getSortedString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
