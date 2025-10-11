package test.xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//街区有n个路灯，分别为1到n，路灯之间使用电线连接，一盏路灯亮起则与其同一链路的路灯也会亮起。现在停电了，小明希望知道如果给一号路灯通电，会有多少路灯亮起。
//输入描述：第一行输入两个整数n m，n表示路灯数量，m表示路灯之间连接关系的数量
//接下来的m行每行两个整数，表示相连的两个路灯的编号，空格隔开
//输出：如果一号路灯被点亮，会有多少个路灯被点亮
//
//样例
//5 3
//1 2
//2 3
//4 5
//期望输出
//3
public class a1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //n m分别表示路灯数量与链接关系组
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //简历n*n邻接表
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        //在这里的m行内建立路灯之间的关系
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];

        //使用dfs
        int number = dfs(graph, 0, visited);

        System.out.println(number);
    }

    public static int dfs(List<List<Integer>> graph, int start, boolean[] visited) {
        //访问过的 返回0
        if (visited[start]) return 0;
        //标记访问
        visited[start] = true;

        int number = 1;
        //递归访问相邻节点
        for (int neighbor : graph.get(start)) {
            if (!visited[neighbor]) {
                number += dfs(graph, neighbor, visited);
            }
        }

        return number;
    }
}
