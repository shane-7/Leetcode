package Everyday;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-03-21 14:43
 */

/*
    he 数组：存储是某个节点所对应的边的集合（链表）的头结点；
    e  数组：由于访问某一条边指向的节点；
    ne 数组：由于是以链表的形式进行存边，该数组就是用于找到下一条边；
    w  数组：用于记录某条边的权重为多少。
    idx 是用来对边进行编号的
 */

public class Match20_2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        // 算出每个服务器到主服务器的距离
        // 根据patience time 计算它重发了多少次数据
        // 算出每个服务器所有发送的数据最后到达的时间
        // 取最大值+1返回即可
        int n = patience.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        // BFS求出每个服务器到主服务器的最短路径
        int[] distances = new int[n];
        int d = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.poll();
                for (int next : g[node]) {
                    // 每个节点只需要放一次，充当了visited数组来使用
                    if (distances[next] == 0) {
                        queue.offer(next);
                        distances[next] = d;
                    }
                }
            }
            d++;
        }

        // 下面的for循环可以跟上面的BFS放一起，分开是为了代码清晰
        // 计算每个服务器最短时间
        int[] times = new int[n];
        for (int i = 1; i < n; i++) {
            int p = patience[i];
            int dist = distances[i];
            // 假设p=2,d=2，一条消息发送出去到回来需要4秒，等于2的两倍，会发送两条消息
            // 假设p=3,d=2，一条消息发送出去到回来需要4秒，大于3，会发送两条消息
            // 假设p=4,d=2，一条消息发送出去到回来需要4秒，等于4，只会发送一条消息
            // 每条消息耗费的时长为 2*d，所以，总的时间为最后一条消息发送的时间 + 来回的时间
            times[i] = (2 * dist - 1) / p * p + 2 * dist;
        }

        // 下面的循环可以和上面的合并在一起，分开写是为了代码逻辑清晰
        int max = 0;
        for (int time : times) {
            max = Math.max(max, time);
        }
        // 题目要求的是返回第几秒空闲，也就是最后一条消息到达从服务器的时间加一
        return max + 1;
    }


    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2}};
        int[] patience = {0,2,1};

        Match20_2039 test = new Match20_2039();
        int res = test.networkBecomesIdle(edges, patience);
        System.out.println(res);

        System.out.println(Arrays.deepToString(edges));
    }
}

