package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 复原IP地址
 * @author: maple
 * @create: 2020-04-01 17:25
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class restoreIpAddresses {

    public static void main(String[] args) {
        String s = "25525511135";
        restoreIpAddresses(s);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        LinkedList linkedList = new LinkedList();
        dfs(s, 0, 0, linkedList, list);
        list.forEach(index -> {
            System.out.println(index);
        });
        return list;
    }

    static int isIpAdress(String s, int start, int end) {
        int len = end - start+1;

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(end) == '0') {
            return -1;
        }

        // 转成 int 类型
        int res = 0;
        for (int i = start; i <= end; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }

    static void dfs(String s, int start, int count, LinkedList<String> path, List<String> res) {
        if (start == s.length()) {
            if (count == 4)
                res.add(String.join(",", path));
            return;
        }
        if (s.length() - start < 4 - count || s.length() - start > 3*(4-count)){
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (start + i >= s.length()) break;
            int ip = isIpAdress(s, start, start + i);
            if (ip != 1) {
                path.addLast(ip + "");
                dfs(s, start + i + 1, count++, path, res);
                path.removeLast();
            }
        }
    }
}
