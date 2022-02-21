package Greed;

import java.util.Arrays;

/** 455.分发饼干
 *
 * 本题关键点：用Index来控制饼干数组的遍历，遍历饼干并没有再起一个for循环，而是采用自减的方式，这也是常用的技巧。
 * @author shkstart
 * @create 2021-11-23 17:01
 */
public class Greed2_455 {

    //方法1：大饼干先喂饱大胃口
    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int Index = s.length - 1;//饼干数组的下标
        int result = 0;
        for(int i = g.length - 1;  i >= 0; i--){
            if(Index >= 0 && s[Index] >= g[i]){
                result++;
                Index--;
            }
        }
        return result;
    }

    //方法2：小饼干先喂饱小胃口
    public int findContentChildren1(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int Index = 0;  //胃口数组的下标
        int result = 0;
        for(int i = 0; i < s.length; i++){
            if(Index < g.length && g[Index] >= s[i]){
                result++;
                Index++;
            }
        }
        return result;
    }
}
