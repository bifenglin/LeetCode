package SlidingWindow;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-19 17:28
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 **/
public class reverseVowels {
    public static void main(String[] args) {
        String s = "race car";
        System.out.print(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int left = 0;
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        while (right>=left){
            boolean flag = false;
            if (set.contains(chars[right])){
                while (!set.contains(chars[left]) && left < right){
                    flag = true;
                    left++;
                }
                if (right > left && flag){
                    char temp = chars[right];
                    chars[right] = chars[left];
                    chars[left] = temp;
                }
            }
            right--;
        }

        return new String(chars);
    }
}
