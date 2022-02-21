package String;

/** 541.反转字符串Ⅱ
 * @author shkstart
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * @create 2021-09-07 22:38
 */
public class String2_541 {
    public String reverseStr(String s, int k) {
        //先将string转换为char数组
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i += 2 * k){
            int start = i;
            int end = Math.min(chars.length - 1, start + k -1);
            while(start < end){
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
        }
        return new String(chars);  //类型转换
    }

    public static void main(String[] args) {
        String s = "helloworld";
        String2_541 test = new String2_541();
        String s1 = test.reverseStr(s, 2);
        System.out.println(s1);

    }
}
