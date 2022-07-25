package Array.DoublePoint;

/*
两数之和Ⅱ 输入有序数组  二分 mid
 */
public class DB5_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else {
                ans[0] = left + 1; ans[1] = right + 1;
                break;
            }
        }
        return ans;
    }

}
