package String;

/**
 * @author shkstart
 * @create 2021-09-09 9:47
 */
public class String3_jzof05 {
    public static String replaceSpace(StringBuffer str) {
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

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("we are happy");

        String res = replaceSpace(str);
        System.out.println(res);

    }
}
