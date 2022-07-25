package 宫水三叶.二叉树;

/** 搜索二维矩阵 II
 * @author shkstart
 * @create 2022-04-18 18:11
 */
public class Mid2_240 {

    //从右上角元素开始，类似BST
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        while(r < m && c >= 0)
            if(matrix[r][c] > target){
                c--;
            }else if(matrix[r][c] < target){
                r++;
            }else{
                return true;
            }
        return false;
    }

    //二分查找
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            int left = 0;
            int right = matrix[i].length - 1;
            int[] nums = matrix[i];
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] > target){
                    right = mid - 1;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    return true;
                }
            }
        }
        return false;

    }
}
