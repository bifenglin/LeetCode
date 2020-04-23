package binary;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-04 15:23
 **/
public class binarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int key = 5;
        System.out.println(binarySearch(nums, key));
    }

    static int binarySearch(int[] nums, int key) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int m = left + (right - left)/2;
            if (nums[m] == key){
                return 1;
            }
            if (nums[m] < key){
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return 0;
    }
}
