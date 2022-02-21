package HashMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-08-17 9:28
 */
public class HashMap2_1002 {
    public List<String> commonChars(String[] words){
        List<String> result = new ArrayList<>();
        //1.特殊情况判断
        if(words.length == 0){
            return result;
        }
        //2.构造hash, 用来统计所有字符串里字符出现的最小频率
        int[] hash = new int[26];
        //3.用第一个字符串给hash初始化
        for(int i = 0; i < words[0].length(); i++){
            hash[words[0].charAt(i) - 'a']++;
        }
        //4.统计除第一个字符串外字符的出现频率
        for(int i = 1; i < words.length; i++){
            int[] hashOtherStr = new int[26];
            for(int j = 0; j < words[i].length(); j++){
                hashOtherStr[words[i].charAt(j) - 'a']++;
            }
            //4.1更新hash，保证hash里统计的26个字符在所有字符串里出现的是最小次数
            for(int k = 0; k < 26; k++){
                hash[k] = Math.min(hash[k], hashOtherStr[k]);
            }
        }
        //5.将hash统计的字符次数，转成输出形式，注意用while来消除重复字符
        for(int s = 0; s < 26; s++){
            while(hash[s] != 0){
                char c = (char)(s + 'a'); //这里的ASCII码用的好
                result.add(String.valueOf(c));   //String.valueof()是将字符转换成字符串
                hash[s]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        HashMap2_1002 test = new HashMap2_1002();
        List<String> result1 = new ArrayList<>();
        result1 = test.commonChars(A);
        Iterator<String> it1 = result1.iterator();
        while(it1.hasNext()){
            System.out.print(it1.next() + "->");
        }
//        System.out.println(result.toString());
    }
}
