package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-11-22 13:05
 */
public class BackTr10_93 {

    List<String> result = new ArrayList<>();
    int pointNum = 0;

    private void backTracking(String s, int startIndex, int pointNum){
        //确定终止条件
        if(pointNum == 3){
            if(isValid(s, startIndex, s.length() - 1)){
                result.add(s);
            }
            return;
        }
        //单层搜索逻辑
        for(int i = startIndex; i < s.length(); i++){
            if(isValid(s,startIndex, i )){
                s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                pointNum++;
                backTracking(s, i + 2, pointNum);;
                pointNum--;  //回溯
                s = s.substring(0, i + 1) + s.substring(i + 2); //回溯删掉逗号
            }else {
                break;
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) return result; //算是剪枝
        backTracking(s, 0,0);
        return result;
    }



    private boolean isValid(String s, int start, int end){
        if(start > end){
            return false;
        }
        //区间为0开头的数字不合法
        if(s.charAt(start) == '0' && start != end){
            return false;
        }

        int num = 0;
        for(int i = start; i <= end; i++){
            //区间里有非正整数的字符不合法
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                return false;
            }
            //区间中如果大于255不合法
            num = num * 10 + s.charAt(i) - '0';
            if(num > 255){
                return false;
            }
        }
        return true;
    }
}
