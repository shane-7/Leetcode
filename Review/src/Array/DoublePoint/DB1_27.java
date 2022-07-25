package Array.DoublePoint;

/**
 * 移除元素
 */
public class DB1_27 {
    public static int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }else{
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
//        int res = DB1_27.removeElement(new int[]{0, 1, 2, 3, 3, 0, 4, 2}, 2);
//        int res1 = DB1_27.removeElement(new int[]{3,2,2,3}, 3);
        int res2 = DB1_27.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        System.out.println(res2);
    }
}
