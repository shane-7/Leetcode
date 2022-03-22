package Week_Compete.week285;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 10:49
 */
public class T2 {
    public int countCollisions(String directions) {
//        StringBuilder dc = new StringBuilder(directions);
//        //双指针
//        int preIndex = 0;
//        int postIndex = 1;
//        int cnt = 0;
//
//        boolean move = true;

//        while(preIndex < dc.length() - 1){
//            //如果碰到"RL"，将RL替换成's'
//            if(dc.charAt(preIndex) == 'R' && dc.charAt(postIndex) == 'L'){
//                cnt += 2;
//                dc.setCharAt(preIndex, 'S');
//                dc.deleteCharAt(postIndex);
//            }
//            if(postIndex < dc.length() - 1 && dc.charAt(preIndex) == 'S' && dc.charAt(postIndex) == 'L'){
//                cnt++;
//                dc.deleteCharAt(postIndex);
//                move = false;
//            }
//            if(postIndex < dc.length() - 1 && dc.charAt(postIndex) == 'S' && dc.charAt(preIndex) == 'R'){
//                cnt++;
//                dc.deleteCharAt(preIndex);
//                move = false;
//
//            }
//            if(move){
//                preIndex++;
//                postIndex++;
//            }
//            if(dc.length() <= 2){
//                break;
//            }
//
//        }

//        while(postIndex < dc.length()){
//            if(dc.charAt(preIndex) == 'R' && dc.charAt(postIndex) == 'L'){
//                cnt += 2;
//                dc.setCharAt(preIndex, 'S');
//                dc.deleteCharAt(postIndex);
//            }
//            preIndex++;
//            postIndex++;
//
//        }
//
//        preIndex = 0;
//        postIndex = 1;
//
//        List<Integer> list = new ArrayList<>();
//
//        for(int i = 0; i < dc.length(); i++){
//            if(dc.charAt(i) == 'S'){
//                list.add(i);
//            }
//        }
//
//        for(int j = 0; j < list.size(); j++){
//            if(list.get(j) == 0 ){
//
//            }
//        }
        char[] dirs = directions.toCharArray();
        int n = dirs.length, cnt = 0;

        // 统计 L 操作出现的碰撞次数
        boolean leftLimit = false;
        for (int i = 0; i < n; i++) {
            // 左侧有车辆 S 或 R 时，说明左侧有界(L操作肯定会碰撞)
            if (!leftLimit && dirs[i] != 'L') leftLimit = true;

            if (dirs[i] == 'L' && leftLimit) cnt++;
        }

        // 统计 R 操作出现的碰撞次数
        boolean rightLimit = false;
        for (int i = n - 1; i >= 0; i--) {
            // 左侧有车辆 S 或 L 时，说明左侧有界(R操作肯定会碰撞)
            if (!rightLimit && dirs[i] != 'R') rightLimit = true;
            if (dirs[i] == 'R' && rightLimit) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        T2 test = new T2();
        String directions = "RLRSLL";
        int res = test.countCollisions(directions);
        System.out.println(res);
    }
}
