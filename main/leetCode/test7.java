package leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class test7 {
    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            // 获取最后一位数字
            int digit = x % 10;

            // 检查是否会溢出
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 ||
                    (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // 构建反转后的数字
            result = result * 10 + digit;

            // 去掉最后一位数字
            x /= 10;
        }

        return result;
    }
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }
}
