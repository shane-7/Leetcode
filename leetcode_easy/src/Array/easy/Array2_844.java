package Array.easy;

/**844比较含退格的字符串, 具体看题解.
 *  难度0.6
 * @author shkstart
 * @create 2021-07-14 10:28
 */
public class Array2_844 {
    //方法一：重构字符串
    //思路：我们用栈处理遍历过程，每次我们遍历到一个字符：
    //
    //如果它是退格符，那么我们将栈顶弹出；
    //
    //如果它是普通字符，那么我们将其压入栈中。
    public boolean backSpaceCompare1(String S, String T){
        return build(S).equals(build(T));
    }

    public String build(String str){
        StringBuffer ret = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '#'){
                ret.append(str.charAt(i));
            }else{
                if(ret.length() > 0){
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }


    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(S.charAt(i) == '#') {
                    skipS++;
                    i--;
                }else if(skipS > 0){
                    skipS--;
                    i--;
                }else{
                    break;
                }
            }
            while(j >= 0){
                if(T.charAt(j) =='#'){
                    skipT++;
                    j--;
                }else if(skipT > 0){
                    skipT--;
                    j--;
                }else {
                    break;
                }
            }

            if(i >= 0 && j >= 0){
                if(S.charAt(i) != T.charAt(j)){
                    return false;
                }
            }else {
                if(i >= 0 || j >=0){
                    return false;
                }
            }
            i--;
            j--;

        }
        return true;
    }

    public static void main(String[] args) {
        Array2_844 test = new Array2_844();
        String S = "bbbextm", T = "bbb#extm";
//        System.out.println(test.backspaceCompare(S, T));
        System.out.println(test.backSpaceCompare1(S, T));
    }

}
