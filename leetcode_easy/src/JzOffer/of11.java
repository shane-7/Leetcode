package JzOffer;

/** 旋转数组的最小数字
 * @author shkstart
 * @create 2022-03-30 17:25
 */

//推断比较难
public class of11 {
    public int minArray(int[] numbers) {
        if(numbers.length == 1) return numbers[0];
        int i = 0, j = numbers.length - 1;
        int m = (i + j) >> 1;
        while(i < j){
            if(numbers[m] < numbers[j]) j = m;
            else if (numbers[m] > numbers[j]) i = m + 1;
            else j--;  //相等则j--
            m = (i + j) >> 1;
        }
        return numbers[i];
    }

}
