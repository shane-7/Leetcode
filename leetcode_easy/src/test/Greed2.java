package test;

import java.util.Arrays;

/** 455.分发饼干
 *  小饼干先喂饱小胃口
 *  g[] 孩子， s[] 饼干
 * @author shkstart
 * @create 2021-11-24 9:40
 */
public class Greed2 {
    public int findContentChildren(int[] g, int[] s){
        //先排序
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int childNum = 0;
        for(int i = 0; i < s.length; i++){
            if(childNum < s.length && g[childNum] <= s[i]){
                childNum++;
                res++;
            }
        }
        return res;
    }
}
