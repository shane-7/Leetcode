package doublepointer;

/** 88合并两个数组
 * @author shkstart
 * @create 2022-04-02 15:16
 */
public class wiki_dp10_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] arr = new int[m + n];
        int index = 0;
        while (i < m || j < n){
            if(i < m && j < n){
                arr[index++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if(i < m){
                arr[index++] = nums1[i++];
            } else if(j < n){
                arr[index++] = nums2[j++];
            }
        }
        System.arraycopy(arr, 0, nums1, 0, m + n);
    }

}
