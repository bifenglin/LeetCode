package stringArithmetic;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class isPalindrome {
    public static void main(String[] args) {
        String s = new String("AaVaa");
        System.out.print(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (low < high && !isAlphanum(s.charAt(low))) {//从前往后遍历，既不是字母又不数字，则略过
                low++;
            }
            while (low < high && !isAlphanum(s.charAt(high)))
                high--;
            if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {//如果对称位置的不相等
                return false;
            }
            low++;
            high--;
        }
        return true;

    }

    static boolean isAlphanum(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9');
    }
}
