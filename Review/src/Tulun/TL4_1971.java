package Tulun;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TL4_1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] r : edges){
            int a = r[0];
            int b = r[1];
            Set<Integer> s1 = map.getOrDefault(r[0], new HashSet<>());
            s1.add(r[1]);
            map.put(r[0], s1);
            Set<Integer> s2 = map.getOrDefault(r[1], new HashSet<>());
            s2.add(r[0]);
            map.put(r[1], s2);
        }


        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(source);
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-- > 0){
                int poll = deque.pollFirst();
                Set<Integer> set = map.get(poll);
                if(set.contains(destination)) return true;
                for(int i : set){
                    deque.addLast(i);
                }
            }
        }
        return false;
    }


}
