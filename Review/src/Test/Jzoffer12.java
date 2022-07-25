package Test;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;
import javafx.concurrent.Worker;

public class Jzoffer12 {
    static boolean[][] visited;
    static String word1;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        word1 = word;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, int i, int j, int wordIdx){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j] || board[i][j] != word1.charAt(wordIdx))
            return false;
        if(wordIdx == word1.length() - 1) return true;
        visited[i][j] = true;
        boolean res = dfs(board, i - 1, j, wordIdx + 1) || dfs(board, i + 1, j, wordIdx + 1) ||
                      dfs(board, i, j - 1, wordIdx + 1) || dfs(board, i, j + 1, wordIdx + 1);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        Jzoffer12 jzoffer12 = new Jzoffer12();
        boolean res = jzoffer12.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
        System.out.println(res);
    }
}
