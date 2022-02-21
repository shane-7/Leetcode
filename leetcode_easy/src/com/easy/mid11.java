package com.easy;

import java.util.ArrayList;

/**
 * 盛最多容器的水（双指针法）
 *
 * @author shkstart
 * @create 2021-05-11 14:32
 */
public class mid11 {
    public int maxArea(int[] height){
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        for(int i = 0; i < height.length; i++){
            int area = Math.min(height[left], height[right]) * Math.abs(right - left);
            if(area > max){
                max = area;
            }
            if(height[left] < height[right]){
                left++;
            }else if(height[left] > height[right]){
                right--;
            }
            if(left == right){
                break;
            }
        }
       // Collections.sort(list, Collections.reverseOrder());
        //return list.get(0);
        return max;

    }

    public static void main(String[] args) {
        mid11 test1 = new mid11();
        int[] height = new int[]{4,3,2,1,4};
        int result = test1.maxArea(height);
        System.out.println(result);
    }
}
