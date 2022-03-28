package Everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-13 9:04
 */
public class March13_393_1 {
    public boolean validUtf8(int[] data) {
        List<String> dataList = new ArrayList<>();
        //将data数组转换为二进制的字符串数组
        for(int i : data){
            String s = Integer.toBinaryString(i);
            int binaryInt = Integer.parseInt(s);
            dataList.add(String.format("%08d", binaryInt));
        }

        for(int i = 0; i < dataList.size(); ){
            String s1 =  dataList.get(i);
            int count_1 = 0;
            if(s1.charAt(0) == '0') {
               i++;
               continue;
           }
           for(int j = 0; j < s1.length(); j++){
               if(s1.charAt(j) == '1'){
                   count_1++;
               }else {
                   break;
               }
           }
           if(count_1 == 1 || count_1 > 4) return false;

           int a = i + count_1 - 1;
           if(a > dataList.size()) return false;
           i++;
           while(i <= a){
               String s2 = dataList.get(i);
               if(s2.charAt(0) != '1' || s2.charAt(1) != '0'){
                   return false;
               }
               i++;
           }
        }
        return true;

    }

    public static void main(String[] args) {
        March13_393_1 test = new March13_393_1();
        int[] data = {237};
//        boolean res = test.validUtf8(data);
//        System.out.println(res);
        boolean res = test.validUtf8(data);
        System.out.println(res);
    }
}
