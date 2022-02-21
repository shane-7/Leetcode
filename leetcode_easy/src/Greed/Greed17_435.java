package Greed;

import java.util.Arrays;
import java.util.Comparator;

/** 435.无重叠区间
 *  按照右边界的问题
 * @author shkstart
 * @create 2021-12-02 10:32
 */
public class Greed17_435 {

    public int eraseOverlapIntervals(int[][] intervals){
        //先对数组按照右边界位置进行从大到小排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[1] - b[1];    //按第一列元素进行从小到大排列
            }
        });

        if(intervals.length == 0) return 0;
        //记录非交叉的个数
        int count = 1;
        //记录右边界（区间分割点）：
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(end <= intervals[i][0]){  //产生非交叉
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

//    public static void main(String[] args) {
//        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        //先对数组按照起始位置进行排序
//        Arrays.sort(points, new Comparator<int[]>() {
//            public int compare(int[] a, int[] b){
//                return a[1] - b[1];    //按第一列元素进行从小到大排列
//            }
//        });
//
//        for(int i = 0; i < points.length; i++){
//            System.out.print(Arrays.toString(points[i]));
//        }
//    }
}
