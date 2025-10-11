package test.tj;
//第三题：
//题目描述：
//期末周到了，喵呜酱还没开始复习。
//喵呜酱有n（1≤n≤100）门考试，有k（1≤k≤10^4）天的时间可以复习。因为还要更新QT所以一天只能复习一门课。
//假如一门课一天都没复习，喵呜酱就会考0分。对于第i门课，每复习1天，这门课就会增加ai（1≤ai≤100）分。但是一门课不会超过100分，因此若复习前分数为wi，则复习后分数为min(wi+ai,100)。
//喵呜酱想要规划一个复习方案，使得考试是最低分尽可能高。但是喵呜酱急着更新QT，所以把这个任务交给了你。
//你只需要回答在最好的规划方式下，考试的最低分是多少。
//
//输入格式：
//每个测试点包含多组测试数据。
//第一行，一个整数T(1≤T≤10），表示测试组数。
//对于每组数据：
//第一行一个整数n，k（1≤n≤100，1≤k≤10^4），表示科目数和复习天数。
//第二行，共n个整数，其中第i个数表示ai（1≤ai≤100）。
//保证∑n≤100，∑k≤10^4。
//
//输出格式：
//对于每个测试数据，输出一行一个整数表示答案。
//
//输入样例：
//2
//2 3
//10 20

//4 10
//1 2 3 4
//输出样例：
//20
//4
import java.util.Arrays;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取测试组数
        int T = scanner.nextInt();

        // 处理每组测试数据
        for(int i = 0; i < T; i++) {
            //第一个数据是本组科目数
            int num = scanner.nextInt();
            //第二个科目是复习天数
            int day = scanner.nextInt();
            //对于每个科目的基础分
            int[] base = new int[num];
            for(int j = 0; j < num; j++) {
                base[j] = scanner.nextInt();
            }
            //对其执行一次算法
            deal(base,day);
        }

        scanner.close();
    }
    public static void deal(int[] base, int day)
    {
        //在days天内保证最低分的科目分数尽可能高，但是上限是100
        //说白了就是先预设一个分数 然后检查是否能达到
        //二分查找，先50，能达到50就75.......
        int min = 0;
        int max = 100;
        int reachGoal=0;
        //二分
        while(min < max){
            int mid = (min + max) / 2;
            if(canReach(base,day,mid)){
                min = mid + 1;
                reachGoal = mid;
            }else max = mid;
        }

        System.out.println(reachGoal);
    }

    public static boolean canReach(int[] base, int day, int reachGoal)
    {
        //每门课能否达到reachGoal？
        //先计算达到需要的天数
        //在计算和是否满足day条件
        int needDays = 0;
        for (int j : base) {
            needDays += reachGoal / j;
            if (reachGoal % j != 0)
                needDays++;
        }
        return needDays <= day;
    }
}
