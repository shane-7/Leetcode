package HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/** 349.两个数组的交集
 * @author shkstart
 * @create 2021-08-18 9:41
 */
public class HashMap3_349 {
    public int[] intersection(int[] nums1, int[] nums2){
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();

        //遍历数组1
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

        //遍历数组2
        for(int i = 0; i < nums2.length; i++){
            if(set1.contains(nums2[i])){
                resSet.add(nums2[i]);
            }
        }

        int[] resArr = new int[resSet.size()];
        int index = 0;
        //将结果转为数组
        //方式1:
        Iterator<Integer> it1 = resSet.iterator();  //HashSet的遍历方法要记住

        for(int i = 0; i < resArr.length; i++){
            if(it1.hasNext()){
                resArr[i] = it1.next();
            }
        }
        return resArr;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        HashMap3_349 test = new HashMap3_349();
        int[] result = test.intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
