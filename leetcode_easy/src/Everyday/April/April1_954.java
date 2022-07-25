package Everyday.April;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-04-01 13:37
 */
public class April1_954 {
    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Map<Integer, Integer> termFreq = new HashMap<>();
        for(int i = 0; i < n; i++){
            termFreq.put(arr[i], termFreq.getOrDefault(arr[i], 0) + 1);
        }
        // 从大数开始遍历. 自己补充：如果从大数开始遍历的话，那么只要一直除2就好了。 如果从小数开始遍历，小数乘以2容易超出范围，NullPointException!!!
        for(int i = n - 1; i >= 0; i--){
            if((arr[i] & 1) == 0 && termFreq.containsKey(arr[i]) && termFreq.containsKey(arr[i] >> 1)){
                // 如果arr[i]是偶数，并且它和它的一半都还在词频表里，就直接减频数
                int half = arr[i] >> 1;
                termFreq.put(arr[i], termFreq.get(arr[i]) - 1);
                termFreq.put(half, termFreq.get(half) - 1);
                if(termFreq.get(arr[i]) == 0){
                    termFreq.remove(arr[i]);
                }
                 //注意arr[i]和half可能是同一个数
                if(termFreq.getOrDefault(half, 0) == 0){
                    termFreq.remove(half);
                }
            }
        }
        return termFreq.isEmpty();
    }


    public static void main(String[] args) {
        int[] arr = {4, -2, 2, -4};
        April1_954 test = new April1_954();
        boolean res = test.canReorderDoubled(arr);
        System.out.println(res);
    }

}
