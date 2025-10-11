package test.xiaomi;

import java.util.Scanner;
//模拟解一次方程，现有字符串，内涵 + - = 与一个小写字母 与若干数字组成的方程 注意：
//方程内的数字均为整数，且小于100000
//符号-可以理解为减号或者负号
//如果结果为0应该输出正0，而非-0
//给出的字符串没有空格，也不会出现任何非法算子例如a1 a2这种字母直接拼接数字的情况
//
//测试输入 a+1=2a-9 期望输出 a=10.000
public class a2 {
    public static void main(String[] args) {
        //模拟解方程，接收一串字符串表示方程
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        //过程：
        //对于2a+1=a+3
        //先计算字母系数和，再计算非字母数字的和

        //根据等号拆解为两部分
        //找出变量，计算变量前系数和，此时剔除变量，剩下的为纯数字+符号
        //再计算纯数字

        //找变量
        char variable = ' ';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                variable = c;
                break;
            }
        }

        //分割
        String[] parts = str.split("=");
        String left = parts[0];
        String right = parts[1];

        double[] leftReal = parseExpression(left, variable);
        double[] rightReal = parseExpression(right, variable);

        //左右字母系数 数字和
        double leftCoefficientSum = leftReal[0];
        double leftNumberSum = leftReal[1];
        double rightCoefficientSum = rightReal[0];
        double rightNumberSum = rightReal[1];

        //变量移动到左边，数字移动到右边
        double totalCoefficient = leftCoefficientSum - rightCoefficientSum;
        double totalNumber = rightNumberSum - leftNumberSum;

        double result = totalNumber / totalCoefficient;

        //拒绝-0
        if (Math.abs(result) < 1e-10) {
            result = 0.000;
        }
        System.out.printf("%c=%.3f\n", variable, result);
    }

    //解析表达式，返回 系数 常数
    public static double[] parseExpression(String expression, char variable) {
        double coefficient = 0;
        double constant = 0;

        //开头不是负号就加正号
        if (expression.charAt(0) != '-' && expression.charAt(0) != '+') {
            expression = "+" + expression;
        }

        //开始扫描
        int i = 0;
        while (i < expression.length()) {
            //当前项符号
            char sign = expression.charAt(i);
            //符号代表的系数
            int signValue = sign == '+' ? 1 : -1;
            i++;

            int j = i;
            //切割子数字单元
            while (j < expression.length() && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            String numberStr = expression.substring(i, j);
            if (numberStr.indexOf(variable) != -1) {
                //处理变量 numberStr.substring(0,numberStr.indexOf( variable));
                String coefficientStr = numberStr.substring(0, numberStr.indexOf(variable));
                if (coefficientStr.isEmpty()) {
                    //例如 +a
                    coefficient += signValue;
                } else if (coefficientStr.equals("-")) {
                    coefficient -= signValue;
                } else {
                    coefficient += signValue * Double.parseDouble(coefficientStr);
                }
            } else {
                //处理常数
                constant += signValue * Double.parseDouble(numberStr);
            }
            i=j;
        }
        return new double[]{coefficient, constant};
    }
}
