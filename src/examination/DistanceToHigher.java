package examination;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-22 19:03
 **/
public class DistanceToHigher {
    public static void main(String[] args) {
        int[] height = new int[]{175, 173, 174, 163, 182, 177};
        int[] res = DistanceToHigher(height).clone();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    static int[] DistanceToHigher(int[] height){
        int[] res = new int[height.length];
        if (height.length <= 1) return res;
        for (int i = 1; i < height.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (height[j] > height[i]){
                    res[i] = i-j;
                    break;
                }
            }
        }
        return res;
    }
}
