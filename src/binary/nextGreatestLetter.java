package binary;

/**
 * @program: LeetCode
 * @description: 寻找比目标字母大的最小字母
 * @author: maple
 * @create: 2020-04-04 16:34
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * <p>
 * 在比较时，数组里字母的是循环有序的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 * 如果目标字母 target = 'n' 并且有序数组为 letters = ['m', 'z', 'c', 'f', 'j'] ，则答案返回 'z' 。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 *  
 * <p>
 * 提示：
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class nextGreatestLetter {
    public static void main(String[] args) {
        String s = "cfj";
        System.out.println(nextGreatestLetter(s.toCharArray(), 'k'));
    }

    static char nextGreatestLetter(char[] letters, char target){
        int l = 0;
        int r = letters.length-1;
        while (l < r){
            if (letters[r] <= target){
                return letters[l];
            }
            int m = l + (r-l)/2;
            if (letters[m] <= target){
                l = m + 1;
            } else {
                r = m;
            }
        }
        return letters[r];

    }

}
