package Week_Compete.week287;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-04-03 11:16
 */
public class T2 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < matches.length; i++){
            if(!map.containsKey(matches[i][0])) map.put(matches[i][0], 0);
            map.put(matches[i][1], map.getOrDefault(matches[i][1],0) + 1);
        }
        List<Integer> winList = new ArrayList<>();
        List<Integer> loseOneList = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == 0) winList.add(key);
            if(map.get(key) == 1) loseOneList.add(key);
        }
        Collections.sort(winList);
        Collections.sort(loseOneList);
        List<List<Integer>> res = new ArrayList<>();
        res.add(winList);
        res.add(loseOneList);
        return res;
    }
}
