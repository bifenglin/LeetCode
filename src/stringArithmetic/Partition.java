package stringArithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
["aa","b"],
["a","a","b"]
]*/
public class Partition {
    public static void main(String[] args) {
        String input = "aab";
        int len = input.length();
        Stack path = new Stack();
        List<List<String>> res = new ArrayList<>();
        BackTrace(0, input, len, path, res);
        res.forEach(index -> {
            System.out.println(index);
        });

    }


    public static void BackTrace(int start, String s, int len, Stack path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (!isPalindrome(s, start, i))
                continue;
            path.add(s.substring(start, i + 1));
            BackTrace(start + 1, s, len, path, res);
            path.pop();
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}
