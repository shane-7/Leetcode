package doublepointer;

/** 剑指offer 05.替换空格为"20%"
 * @author shkstart
 * @create 2021-09-17 8:21
 */
public class dp3_jzof05 {
    public static String replaceSpace(StringBuffer str){
        if(str == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(" ".equals(String.valueOf(str.charAt(i)))){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
