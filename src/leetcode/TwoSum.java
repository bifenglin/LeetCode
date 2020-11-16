package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @program: LeetCode
 * @description:
 * @author: bifenglin
 * @create: 2020-11-12 13:04
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 4};
        int[] result = twoSum(input, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
