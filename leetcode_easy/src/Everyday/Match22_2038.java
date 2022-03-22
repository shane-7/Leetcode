package Everyday;

/**
 * @author shkstart
 * @create 2022-03-22 9:08
 */
public class Match22_2038 {
    public boolean winnerOfGame(String colors) {
        char[] color_char = colors.toCharArray();
        int a = 0, b = 0;
        for(int i = 1; i < color_char.length - 1; i++){
            if(color_char[i] == color_char[i - 1] && color_char[i] == color_char[i + 1]){
                if(color_char[i] == 'A'){
                    a++;
                }else {
                    b++;
                }
            }else {
                continue;
            }
        }
        if(a > b) return true;
        else return false;
    }

    public static void main(String[] args) {
        String colors = "ABBBBBBBAAA";
        Match22_2038 test = new Match22_2038();
        boolean res = test.winnerOfGame(colors);
        System.out.println(res);
    }
}
