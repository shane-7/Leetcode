package Tulun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TL3_1791 {
    public static int findCenter(int[][] edges){
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] r : edges){
            map.put(r[0],map.getOrDefault(r[0], 0)+1);
            map.put(r[1],map.getOrDefault(r[1], 0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == edges.length){
                return entry.getKey();
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        int res = TL3_1791.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}});
        System.out.println(res);
    }

}
