package Everyday.June;

import java.util.Deque;
import java.util.LinkedList;

/** 复写零
 *  题解：https://leetcode.cn/problems/duplicate-zeros/solution/c-by-xiaohu9527-71ld/
 */
public class June17_1089 {
    public void duplicateZeros(int[] arr) {
        int len = arr.length, j = len - 1, k = len - 1;
        for(int i = 0; i <= j; i++){
            if(arr[i] == 0){
                if(i == j){
                    arr[k--] = 0;
                    --j;
                    break;
                }
                --j;
            }
        }
        while(j >= 0){
            if(arr[j] == 0){
                arr[k--] = 0;
            }
            arr[k--] = arr[j--];
        }
    }
}
