package leetCode;

import java.util.ArrayList;

public class test6 {
    public static String convert(String s, int numRows) {
        // 特殊情况：只有一行时直接返回原字符串
        if (numRows == 1) {
            return s;
        }

        // 创建StringBuilder数组，每个元素对应一行
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // 当前字符应该放在第几行
        int currentRow = 0;
        // 移动方向：向下为true，向上为false
        boolean goingDown = false;

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 将字符添加到对应的行中
            rows[currentRow].append(c);

            // 在第一行或最后一行时改变方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // 根据方向更新当前行号
            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        // 将所有行连接起来
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}