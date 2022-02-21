package com.easy;

/**寻找两个正序数组的中位数，要求时间复杂度为 O(log (m+n))
 *
 * 如何把时间复杂度降低到 O(log (m+n)) 呢？如果对时间复杂度的要求有 log，通常都需要用到二分查找，这道题也可以通过二分查找实现。

 根据中位数的定义，当 m+n 是奇数时，中位数是两个有序数组中的第 (m+n)/2 个元素。
 当 m+n 是偶数时，中位数是两个有序数组中的第 (m+n)/2 个元素和第 (m+n)/2+1(m+n)/2+1 个元素的平均值。
 因此，这道题可以转化成寻找两个有序数组中的第 k小的数，其中 k 为 (m+n)/2 或 (m+n)/2+1。


 * @author shkstart
 * @create 2021-04-18 15:52
 */
public class easy4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totlen = length1 + length2;
        if (totlen % 2 == 1){          //如果是奇数
            int midIndex = totlen / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        }else {
            int midIndex1 = totlen / 2, midIndex2 = totlen / 2 + 1;
            double median = (getKthElement(nums1, nums2, midIndex1) + getKthElement(nums1, nums2, midIndex2)) / 2;
//            double median1 = getKthElement(nums1, nums2, midIndex1);
//            double median2 = getKthElement(nums1, nums2, midIndex2);
//            double median = (median1 + median2) / 2;
            return median;
        }

    }

    private static double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while(true){
            //边界情况
            if(index1 == len1){
                return nums2[index2 + k - 1];
            }
            if(index2 == len2){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            //正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;   //keypoint！！！
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int p1 = nums1[newIndex1], p2 = nums2[newIndex2];
            if(p1  <=  p2){
                k -= (newIndex1 - index1 + 1);    //keypoint！！！ 要根据排除数的个数减少K的值，不能直接将k减去k/2
                index1 = newIndex1 + 1;
            }else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }

    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 4, 5, 6};
        int[] nums2 = new int[]{1};
        double midnum = 0;
        midnum = findMedianSortedArrays(nums1, nums2);
        System.out.println("中位数为：" + midnum);
    }
}
