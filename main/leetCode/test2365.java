package leetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test2365 {
    public static long taskSchedulerII(int[] tasks, int space) {
        // 记录每个任务类型最后一次执行的时间
        Map<Integer, Long> lastExecution = new HashMap<>();
        long days = 0;

        for (int task : tasks) {
            days++; // 至少需要一天来执行当前任务

            // 如果之前执行过相同任务
            if (lastExecution.containsKey(task)) {
                long lastDay = lastExecution.get(task);
                // 如果距离上次执行间隔不足space天，则需要等待
                if (days - lastDay <= space) {
                    // 调整到可以执行的最早日期
                    days = lastDay + space + 1;
                }
            }

            // 更新该任务的最后执行时间
            lastExecution.put(task, days);
        }

        return days;
    }
    public static void main(String[] args) {
        int[] tasks = {1,2,1,2,3,1};
        int space = 3;
        System.out.println(taskSchedulerII(tasks, space));
    }
}
