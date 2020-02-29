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
        backtracking(input, 0, len, path, res);
        res.forEach(index -> {
            System.out.println(index);
        });

    }
    /**
     * @param s
     * @param start 起始字符的索引
     * @param len   字符串 s 的长度，可以设置为全局变量
     * @param path  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    private static void backtracking(String s, int start, int len, Stack path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (!checkPalindrome(s, start, i)) {
                continue;
            }

            path.add(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, res);
            path.pop();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，因此，可以采用动态规划先把回文子串的结果记录在一个表格里
     *
     * @param str
     * @param left  子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private static boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
