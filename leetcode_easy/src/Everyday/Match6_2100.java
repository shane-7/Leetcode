package Everyday;

import java.util.ArrayList;
import java.util.List;

/** 2100.适合打劫的日子
 * @author shkstart
 * @create 2022-03-09 10:57
 */
public class Match6_2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int len = security.length;
        //预处理数组
        int[] g = new int[len];

        //这里用g[i]来表示security数组的前后大小的状态，
        //如：security[i] > security[i - 1] 则g[i]为1  递增
        //   security[i] < security[i - 1] 则g[i]为 -1  递减
        //   相等 g[i] 为 0   不变
        for(int i = 1; i < len; i++){
            if(security[i] == security[i - 1]) continue;
            g[i] = security[i] > security[i - 1] ? 1: -1;
        }

        //用a和b来统计g[]中为1的数量，用b来统计g[]中为-1的数量
        //这里采用的累加思想：用 a[i]或b[i] 表示 security数组下标为i(包含i)中 1 或 -1的数量
        int[] a = new int[len + 1], b = new int[len + 1];
        for(int i = 1; i <= len; i++) a[i] = a[i - 1] + (g[i - 1] == 1 ? 1 : 0);  //这种累加的思想很重要
        for(int i = 1; i <= len; i++) b[i] = b[i - 1] + (g[i - 1] == -1 ? 1 : 0);

        List<Integer> res = new ArrayList<>();
        //可以确定答案落在 区间[time, len - time)中
        for(int i = time; i < len - time; i++){
            //下面c1 == 0表示 在i + 1 和 i + 1 - time 区间内没有递增
            //c2 == 0表示 在 i + 1 + time 和 i + 1区间内没有递减
            int c1 = a[i + 1] - a[i + 1 - time], c2 = b[i + 1 + time] - b[i + 1];
            if(c1 == 0 && c2 == 0){
                res.add(i);
            }
        }
        return res;
    }
}
