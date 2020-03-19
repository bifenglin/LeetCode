package examination;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-19 13:57
 **/
public class qiqiu {

    public static void main(String[] args) {
        int target = 5;
        int[] shoots = {2, 5, 3, 1, 3, 2, 4, 1, 0, 5, 4, 3};
        System.out.print(getResult(target, shoots));
    }

    public static int getResult(int target, int shoots[]) {
        int res = -1;
        int left = 0;
        int right = 0;
        int[] colors = new int[shoots.length];
        int colorsCount = 0;
        while (right < shoots.length) {
            // 如果颜色之前没有出现过并且不为0则colorsCount++
            if (colors[shoots[right]] == 0 && shoots[right] != 0) colorsCount++;
            // 增加颜色
            colors[shoots[right]]++;

            // 如果找到所有颜色
            if (colorsCount == target) {
                // 左指针左移
                while (left < shoots.length && (shoots[left] == 0 || colors[shoots[left]] > 1)) {
                    left++;
                    colors[shoots[left]]--;
                }

                int cur_len = right - left + 1;
                if (res == -1 || cur_len < res) {
                    res = cur_len;
                }
            }
            right++;
        }
        return res > target ? res : -1;
    }
}
