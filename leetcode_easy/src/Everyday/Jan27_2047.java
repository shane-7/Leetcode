package Everyday;

/**2047.句子中的有效单词数
 * @author shkstart
 * @create 2022-01-27 9:33
 */
public class Jan27_2047 {
    public int countValidWords(String sentence) {
        char[] st = sentence.toCharArray();
        if(st.length == 1){
            return 1;
        }

        int res = 0;
        for(int j = 0; j < st.length; j++){
            if(st[j] == ' ') continue; //等于空格 continue
        }
        return 0;
    }


    public boolean Total(int startIndex, char[] st, int res){
        for(int i = startIndex; i < st.length; i++){
            if(st[i] == ' ') continue; //等于空格 continue
            if(isMinuscule(st[i])){  //碰到小写字母
                if(isValid(i + 1, st, 0)){
                    res++;
                }else{
                    return false;
                }
            }else {
                return false;
            }
        }
        return false;

    }


    public boolean isMinuscule(char c){
        //判断字符是否是小写字母
        if(48 <= Integer.valueOf(c) && Integer.valueOf(c) <= 57){
            return true;
        }
        return false;
    }

    //判断是否标点符号后，是否还有小写字母，如果有则false
    public boolean isPunctuation(int startIndex, char[] st){
        if(st[startIndex] == '-' || st[startIndex] == ',' || st[startIndex] == '!' || st[startIndex] == '.' ){
            if(isMinuscule(st[startIndex + 1])){
                return false;
            }
        }
        return true;
    }



    //当遍历到小写字母时，判断接下来的字符串是否有效
    public boolean isValid (int startIndex, char[] st, int countUL){

        for (int i = startIndex; i < st.length; i++){
            if(st[i] == ' ') break;
            if(isPunctuation(i, st)){
                if(st[i] == '_' && isMinuscule(st[i + 1])){
                    countUL++;
                }
                if(countUL > 1) return false;
            }

            isValid(i + 2, st, countUL);
        }
        return true;
    }
    public static void main(String[] args) {
        String sentence = "alice and  bob are playing";
        char[] st = sentence.toCharArray();
        System.out.println(Integer.valueOf(st[1]));

    }
}
