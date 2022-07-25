package Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMap2_73 {
    public void setZeros(int[][] matrix){
        Set<Integer> row_zero = new HashSet<>();
        Set<Integer> col_zero = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j ++){
                if(row_zero.contains(i) || col_zero.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
