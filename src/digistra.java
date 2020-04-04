/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-01 15:03
 **/
public class digistra {
    public static void main(String[] args) {

    }

    public static void digistra(int[][] input){
        int temp = Integer.MAX_VALUE;
        int x;
        int y;
        for (int i = 0; i < input.length; i++) {
            // 找到最短距离
            for (int j = 0; j < input.length; j++) {
                if (input[i][j] < temp){
                    temp = input[i][j];
                    x = i;
                    y = j;
                }
            }
            // 更新input值
            for (int j = 0; j < input.length; j++) {
                
            }
        }

    }
}
