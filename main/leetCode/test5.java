package leetCode;

public class test5 {

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        // 预处理字符串，插入特殊字符
        String T = preprocess(s);
        int n = T.length();
        int[] P = new int[n]; // 存储每个位置的回文半径
        int C = 0; // 当前中心
        int R = 0; // 当前右边界

        for (int i = 1; i < n - 1; i++) {
            // i关于C的对称点
            int mirror = 2 * C - i;

            // 利用已知信息初始化P[i]
            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }

            // 尝试扩展回文
            while (T.charAt(i + (1 + P[i])) == T.charAt(i - (1 + P[i]))) {
                P[i]++;
            }

            // 如果扩展后的回文右边界超过R，更新C和R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        // 找到最长回文子串
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // 计算原字符串中的起始位置
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    // 预处理字符串，插入特殊字符
    private static String preprocess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }

        StringBuilder sb = new StringBuilder("^");
        for (int i = 0; i < n; i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
