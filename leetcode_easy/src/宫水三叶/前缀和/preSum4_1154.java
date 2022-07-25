package 宫水三叶.前缀和;

/** 一年中的第几天
 *
 * @author shkstart
 * @create 2022-04-15 8:43
 */
public class preSum4_1154 {
    int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int dayOfYear(String date) {
        String[] strs = new String[3];
        strs[0] = date.substring(0, 4);
        strs[1] = date.substring(5, 7);
        strs[2] = date.substring(8, 10);

        int[] sum = new int[month.length + 1];
        for(int i = 1; i <= month.length; i++){
            sum[i] = sum[i - 1] + month[i - 1];
        }

        int res = 0;
        res += sum[Integer.parseInt(strs[1])];
        res += Integer.parseInt(strs[2]);
        return res;
    }

    public static void main(String[] args) {
        preSum4_1154 test = new preSum4_1154();
        String date = "2019-01-19";
        int res = test.dayOfYear(date);
        System.out.println();
    }
}
