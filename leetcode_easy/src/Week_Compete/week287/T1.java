package Week_Compete.week287;

/**
 * @author shkstart
 * @create 2022-04-03 10:33
 */
public class T1 {
    public int convertTime(String current, String correct) {
        //先取字符串的时位：
        char[] currentChar = current.toCharArray();
        char[] correctChar = correct.toCharArray();

        int cuHour = 0;
        cuHour += (currentChar[0] - '0') * 10;
        cuHour += currentChar[1] - '0';

        int coHour = 0;
        coHour += (correctChar[0] - '0') * 10;
        coHour += correctChar[1] - '0';

        int diffHour = coHour - cuHour;

        int cuMin = 0;
        cuMin += (currentChar[3] - '0') * 10;
        cuMin += currentChar[4] - '0';

        int coMin = 0;
        coMin += (correctChar[3] - '0') * 10;
        coMin += correctChar[4] - '0';

        int diffMin = coMin - cuMin;

        int time = diffHour * 60 + diffMin;


        //接下来算操作数
        int cnt = 0;
        if(time >= 60){
            cnt += time / 60;
            time -= (time / 60) * 60;
        }
        if(time >= 15 && time / 15 != 0){
            cnt += time / 15;
            time -= (time / 15) * 15;
        }
        if(time >= 5){
            cnt += time / 5;
            time -= (time / 5) * 5;
        }
        if(time > 0){
            cnt += time;
        }


        return cnt;
    }

    public static void main(String[] args) {
        T1 test = new T1();
        String curren = "09:41";
        String correc = "10:34";

        int res = test.convertTime(curren, correc);
        System.out.println(res);
    }
}
