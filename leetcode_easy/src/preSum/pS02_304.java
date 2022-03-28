package preSum;
//二维前缀和
/**
 * @author shkstart
 * @create 2022-03-24 15:10
 */
public class pS02_304 {
    int[][] preSum;

    public pS02_304(int[][] matrix) {
        if(matrix.length > 0){
            //与[一维前缀和]一样，前缀和数组下标从1开始，因此设定矩阵形状为[n + 1][m + 1]
            preSum = new int[matrix.length + 1][matrix[0].length + 1];
            //预处理除前缀和（模板部分）
            for(int i = 1; i <= matrix.length; i++){
                for(int j = 1; j <= matrix[0].length; j++){
                    preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 求某一段区域和 [i, j] 的模板是 sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1]
        //      + sum[x1 - 1][y1 - 1];（模板部分）
        // 但由于我们源数组下标从 0 开始，因此要在模板的基础上进行 + 1
        row1++; col1++; row2++; col2++;
        return preSum[row2][col2] - preSum[row2][col1 - 1]
                - preSum[row1- 1][col2] + preSum[row1-1][col1-1];
    }
}
