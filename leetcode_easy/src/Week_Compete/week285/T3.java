package Week_Compete.week285;

/**
 * @author shkstart
 * @create 2022-03-21 9:01
 */
public class T3 {
    //二进制枚举
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = 12;
        int maxScore = 0;
        int[] res = new int[n];

        //开始枚举
        for(int i = 0; i < (1<<n); i++){
            int score = 0;
            int usedArrows = 0;
            int[] bobArrows = new int[n];
            for(int j = 0; j < 12; j++){
                if((i >> j & 1) == 1) {  //那就是在该区域得分了
                    score += j;
                    //使用的箭只需要比alice多1只就可以
                    usedArrows += aliceArrows[j] + 1;
                    bobArrows[j] = aliceArrows[j] + 1; //记录bob箭使用的数量和击中的区域
                }
            }
            if(usedArrows > numArrows) continue;

            if(score > maxScore){
                maxScore = score;
                bobArrows[0] += numArrows - usedArrows;  //把多余的箭射向0区域
                res = bobArrows;
            }
        }
        return res;
    }
}
