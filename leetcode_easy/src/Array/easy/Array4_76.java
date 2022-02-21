package Array.easy;

/**
 * @author shkstart
 * @create 2021-07-30 6:14
 */
public class Array4_76 {
    public static String minWindow(String s, String t) {

        int[] need = new int[128];
        //按照字符串t的内容向need中添加元素
        for(int i = 0; i < t.length(); i++){
            need[t.charAt(i)]++;
        }

        /*
        l: 滑动窗口的左边界
        r: 滑动窗口的右边界
        size：窗口的长度
        count：当次遍历中还需要几个字符才能够满足包含t中所有字符的条件，最大也就是t的长度
        start: 如果有效更新滑动窗口，记录这个窗口的起始位置，方便后续找字串用
         */

        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //循环右边界不超过s的长度
        while(r < s.length()){
            char c = s.charAt(r);
            //如果在t中包含此时的c字符，应该更新count--;
            if(need[c] > 0){
                count--;
            }
            //无论这个字符是否包含在t中，need[]数组中对应那个字符的计数都减少1，利用正负区分这个字符是多余的还是有用的
            need[c]--;
            //when此时窗口包含t中所有字符时：count = 0
            if(count == 0){
                //此时要想办法将当前窗口前面的多余元素去除, 多余元素为 need[s.charAt(l)] < 0
                while(need[s.charAt(l)] < 0){
                    //处理方法：
                    //在need[]数组中更新维护这个值，增加1, 并将窗口右移一个单位，l++
                    need[s.charAt(l)]++;
                    l++;

                }
                //过滤掉多余元素后, 当前窗口的第一个元素应该是t中的元素，此时应该判断窗口的长度值与之前窗口长度的大小，及时更新窗口值
                //和窗口起始值 start
                if(r - l + 1 < size){
                    size = r - l + 1;
                    start = l;
                }
                //接下来将窗口右移一个单位l++，右移注意：过滤掉的第一个字符为t中字符，要将字符数加1，count数也加1
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            //右移右边界，开始下一个大循环
            r++;
        }

        if(size == Integer.MAX_VALUE){
            return "";
        }else{
            return s.substring(start, start + size);
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Array4_76 test = new Array4_76();
        System.out.println(minWindow(s, t));
    }

}
