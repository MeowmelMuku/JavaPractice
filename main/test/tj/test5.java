package test.tj;

import java.lang.reflect.Array;
import java.util.Arrays;

//题目描述：
//给定一个含有n个元素的集合S，你需要计算从集合中取3个整数能够组成非退化的三角形的所有情况有多少种。
//输入格式：
//每个测试点包含多组测试数据。
//第一行，一个整数T(1≤T≤1000），表示测试组数。
//对于每组数据：
//第一行一个整数n(1≤n≤1000)，表示集合大小。
//第二行，包含n个整数ai（1≤ai≤10^7），表示集合元素。
//保证∑n≤5000。
//
//输出格式：
//对于每个测试数据，输出一行一个整数表示答案。
//
//输入样例：
//2
//3
//3 4 7
//3
//3 4 2
//输出样例：
//0
//1
public class test5 {
    public static void main(String[] args) {
        int[] base = {3, 4, 7};

        System.out.println(countTriangles(base));
    }
    public static int countTriangles(int[] base) {
        //先排序
        Arrays.sort(base);
        int count = 0;
        for (int i = 0; i < base.length; i++)
        {
            for (int j = i + 1; j < base.length; j++)
            {
                int k = j + 1;
                while (k < base.length && base[i] + base[j] > base[k])
                {
                    k++;
                    count++;
                }
            }
        }
        return count;

    }
}
