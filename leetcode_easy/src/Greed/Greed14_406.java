package Greed;

import java.util.*;

/**  406.根据身高重建队列。
 *   这一题有一定难度，比如怎么能想到贪心，二维数组怎么进行排序
 *   以及二维数组的基本功：添加，查找索引
 *
 *   很值得多做，多熟悉
 * @author shkstart
 * @create 2021-11-30 10:06
 */
public class Greed14_406 {
    public int[][] reconstructQueue(int[][] people) {
        //排序模块
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return a[1] - b[1];   //如果第一列相同，则按照第二列元素进行从小到大排列
                return b[0] - a[0];    //第一列不相同的元素，按第一列元素进行从大到小排列
            }
        });


        //排序完之后，按照第二列元素大小进行插入
        //void add(int index, E element)：在指定位置插入一个元素。
        LinkedList<int[]> que = new LinkedList<>();
        for(int[] p : people){
            que.add(p[1], p);
        }

        return que.toArray(new int[people.length][]);

    }






    public static void main(String[] args) {

        int[][] people = {{7, 0}, {7, 1}, {6, 1}, {5, 0}, {5, 2}, {4, 4}};

        //排序模块
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return a[1] - b[1];   //如果第一列相同，则按照第二列元素进行从小到大排列
                return b[0] - a[0];    //第一列不相同的元素，按第一列元素进行从大到小排列
            }
        });

        for(int i = 0; i < people.length; i++){
            System.out.print(Arrays.toString(people[i]));
        }

        System.out.println();

        //排序完之后，按照第二列元素大小进行插入
        //void add(int index, E element)：在指定位置插入一个元素。
        LinkedList<int[]> que = new LinkedList<>();
        for(int[] p : people){
            que.add(p[1], p);
        }

        ArrayList<int[]> res = new ArrayList<>(que);
        Iterator<int[]> it1 = res.iterator();
        while(it1.hasNext()){
            System.out.print(Arrays.toString(it1.next()));
        }
    }

}

