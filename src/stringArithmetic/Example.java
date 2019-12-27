package stringArithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Example {
    public static void main(String[] args) {
        String input = "aab";
        int len = input.length();
        Stack path = new Stack();
        List<List<String>> res;
        res = partition(input);
        res.forEach(index -> {
            System.out.println(index);
        });

    }


    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Stack<String> stack = new Stack<>();
        backtracking(s, 0, len, stack, res);
        return res;
    }

    /**
     * @param s
     * @param start 起始字符的索引
     * @param len   字符串 s 的长度，可以设置为全局变量
     * @param path  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    private static void backtracking(String s, int start, int len, Stack<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {

            // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
            // 不是的话，剪枝
            if (!checkPalindrome(s, start, i)) {
                continue;
            }

            path.add(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, res);
            path.pop();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，因此，可以采用动态规划优化
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
