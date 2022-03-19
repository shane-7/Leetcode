package Everyday;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-03-14 13:29
 */
public class Match14_599 {
    //自己用的笨方法
//    public String[] findRestaurant(String[] list1, String[] list2) {
//        int m = list1.length;
//        int n = list2.length;
//
//        int a = 0;  //list1和list2元素相同时，索引的和
//        int min_a = 2000;  //用于存放索引的最小值
//
//        List<String> res = new ArrayList<>();
//
//
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(list1[i].equals(list2[j])){
//                    a = i + j;
//                    if(a <= min_a) {
//                        if(a == min_a){
//                            min_a = a;
//                            res.add(list1[i]);
//                        }else {
//                            res.clear();
//                            res.add(list1[i]);
//                        }
//                    }
//                }
//            }
//        }
//        String[] res_1 = res.toArray(new String[res.size()]);
//        return res_1;
//    }

    //三叶姐用的哈希表模拟法
    public String[] findRestaurant(String[] list1, String[] list2) {
        int m = list1.length;
        int n = list2.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) map.put(list1[i], i);
        List<String> res = new ArrayList<>();
        int min = 2000;
        for(int i = 0; i < n; i++){
            String s = list2[i];
            if(map.containsKey(s)){
                if(i + map.get(s) < min){
                    res.clear();
                    res.add(list2[i]);
                    min = i + map.get(s);
                }else if(i + map.get(s) == min){
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);

    }



        public static void main(String[] args) {
        Match14_599 test = new Match14_599();
        String[] s1 = new String[]{"Shogun","Piatti","Tapioca Express","Burger King","KFC"};
        String[] s2 = new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] res = test.findRestaurant(s1, s2);
        System.out.println(Arrays.toString(res));
    }
}
