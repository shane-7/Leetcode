package stack_And_queue;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-10-16 17:26
 */


public class sAq6_239 {
    public int[] maxSlidingWindow(int[] nums, int k){  //数组nums， 滑动窗口大小k
        if(nums.length == 1){
            return nums;
        }

        int len = nums.length - k + 1;
        int[] res = new int[len];
        MyQueue1 myQueue = new MyQueue1();
        //将前k个数按照自定义队列规则放入队列
        for(int i = 0; i < k; i++){
            myQueue.add(nums[i]);
        }
        //先将第一个滑动窗口的最大值取出来
        int num = 0;
        res[num++] = myQueue.peek();

        for(int i = k; i < nums.length; i++){
            //开始滑动窗口，移除上一个窗口最前面的元素（判断）
            myQueue.poll(nums[i - k]);
            //将此时nums[i]放入队列中（判断）
            myQueue.add(nums[i]);
            //将当前的滑动窗口最大值放入结果数组
            res[num++] = myQueue.peek();
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        sAq6_239 test = new sAq6_239();
        System.out.println(Arrays.toString(test.maxSlidingWindow(nums, k)));
    }
}


