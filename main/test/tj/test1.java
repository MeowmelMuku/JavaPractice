package test.tj;
//题目描述：
//给你一个整数n（1≤n≤10^5），把它转为二进制然后倒过来，转成10进制再输出
//例如，10=(1010)2→(0101)2=5
//
//输入格式：
//每个测试点包含多组测试数据。
//第一行，一个整数T(1≤T≤10^5），表示测试组数。
//接下来T行，每行一个整数n（1≤n≤10^5），表示需要被转换的数。
//
//输出格式：
//对于每个测试数据，输出一行一个整数表示答案。
//
//输入样例：
//2
//10
//8
//输出样例：
//5
//1

import java.util.ArrayList;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取测试组数
        int T = scanner.nextInt();

        // 处理每组测试数据
        for(int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            dealWithNum(n);
        }

        scanner.close();
    }
    public static void dealWithNum(int num)
    {
        stack s = new stack();
        s.init();
        //转二进制
        while(num/2!=0){
            //记录余数
            s.add(num%2);
            num = num/2;
        }
        s.add(num%2);
        //反转到十进制
        int a=0;
        int k=0;
        while (!s.isEmpty()){
            a+= (int) (s.pop()* Math.pow(2,k));
            k++;
        }
        System.out.println("输出" + a);
    }

    public static class stack {
        ArrayList<Integer> stack;

        void init(){
            stack = new ArrayList<>();
        }

        void add(int num){
            stack.add(num);
        }

        int pop(){
            return stack.removeLast();
        }

        boolean isEmpty(){
            return stack.isEmpty();
        }
    }
}
