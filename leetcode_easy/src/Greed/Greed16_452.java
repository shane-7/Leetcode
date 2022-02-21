package Greed;

import java.util.Arrays;
import java.util.Comparator;

/** 452.用最少数量的箭引爆气球
 *   这题的难点，在于需要更新右边界值来判断下一次的重叠情况。
 * @author shkstart
 * @create 2021-11-30 22:40
 */
public class Greed16_452 {
    public int findMinArrowShots(int[][] points){
        //先对数组按照起始位置进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0] - b[0];    //按第一列元素进行从小到大排列
            }
        });

        int res = 1; //points不为空，至少需要一只箭
        for(int i = 1; i < points.length; i++){
            //当两个气球不重叠时，前一个气球的末端小于后一个气球的前端
            if(points[i][0] > points[i-1][1]){
                res++;
            }else{
                points[i][1] = Math.min(points[i - 1][1], points[i][1]); // 更新重叠气球最小右边界
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0] - b[0];    //第一列不相同的元素，按第一列元素进行从小到大排列
            }
        });

        for(int i = 0; i < points.length; i++){
            System.out.print(Arrays.toString(points[i]));
        }


    }
}
