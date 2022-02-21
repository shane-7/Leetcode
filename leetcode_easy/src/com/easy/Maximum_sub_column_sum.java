package com.easy;

/**
 * 求最小子列和的算法3：
 *
 *
 *
 * @author shkstart
 * @create 2021-03-30 22:26
 */
public class Maximum_sub_column_sum {

    //分而治之法：时间复杂度为O(NlogN)

    //在线处理法，时间复杂度为O(n)
    public int MaxSubseqSum4(int A[]){
        int ThisSum, MaxSum;
        int i;
        ThisSum = MaxSum = 0;
        for(i = 0; i < A.length; i++){
            ThisSum += A[i];
            if(ThisSum > MaxSum)
                MaxSum = ThisSum;     //发现更大和则更新当前结果
            else if(ThisSum < 0)
                ThisSum = 0;
        }
        return MaxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 3, -2, 4, -6, 1, 6, -1};
        Maximum_sub_column_sum maximum_sub_sum = new Maximum_sub_column_sum();
        int a = maximum_sub_sum.MaxSubseqSum4(arr);
        System.out.println(a);
    }
}

