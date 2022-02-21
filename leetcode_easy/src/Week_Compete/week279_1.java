package Week_Compete;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-02-06 11:24
 */
public class week279_1 {
    public int[] sortEvenOdd(int[] nums) {
//        int[] odd_num = new int[len / 2];
//
//        if(len % 2 == 0){
//            int[] even_num = new int[len / 2];
//        }else {
//            int[] even_num = new int[len / 2  + 1];
//        }
        int len = nums.length;
        int even_len = 0;



        if(len % 2 == 0){
            even_len = len / 2;
        }else {
            even_len = len / 2 + 1;
        }


        //按非递增顺序重排奇数下标的值
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1 ; i < len; i += 2){
           deque.addLast(nums[i]);
        }
        ArrayList<Integer> odd = new ArrayList<>(deque);
        Object[] odd_list = odd.toArray();
        Arrays.sort(odd_list, Collections.reverseOrder());

        for(int i = 0; i < len / 2; i++){
            nums[2*i + 1] = (int)odd_list[i];
        }


        //按非递减顺序重排偶数下标的值
        Deque<Integer> deque1 = new LinkedList<>();
        for(int i = 0; i < len; i += 2){
            deque1.addLast(nums[i]);
        }
        ArrayList<Integer> even = new ArrayList<>(deque1);
        Object[] even_list = even.toArray();
        Arrays.sort(even_list);

        for(int i = 0; i < even_len; i++){
            nums[2*i] = (int) even_list[i];
        }

        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 3, 0, 6};
//        Deque<Integer> deque = new LinkedList<>();
//        for(int i = 0; i < nums.length; i++){
//            deque.addLast(nums[i]);
//        }
//        ArrayList<Integer> odd_list = new ArrayList<>(deque);
//        Object[] array = odd_list.toArray();
//        Arrays.sort(array, Collections.reverseOrder());
//
//        System.out.println(Arrays.toString(array));

        week279_1 test = new week279_1();
        System.out.println(Arrays.toString(test.sortEvenOdd(nums)));
    }
}
