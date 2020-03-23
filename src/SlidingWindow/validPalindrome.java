package SlidingWindow;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-20 17:41
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 **/
public class validPalindrome {
    public static void main(String[] args) {
        String s = "abc";
        System.out.print(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (right > left) {
            if (s.charAt(left) != s.charAt(right)){
                return (valid(s, left+1, right) || valid(s, left, right-1));
            }
            right--;
            left++;
        }
        return true;
    }

    public static boolean valid(String s, int left, int right){
        while (right > left){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}
