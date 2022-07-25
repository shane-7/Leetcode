package 考试;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

/**
 * @author shkstart
 * @create 2022-04-19 22:10
 */
public class T2 {
    public void method (int num){
        List<Integer> que = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        que.add(2);
        que.add(1);
        que.add(3);
        Collections.sort(que);
        System.out.println(que.toString());
    }

    public static void main(String[] args) {
//        T2 test = new T2();
//        test.method(1);
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[len];
        int i = 0;
        for(String s : strs){
            nums[i++] = Integer.parseInt(s);
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
