package greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 划分字母区间
 * @author: maple
 * @create: 2020-03-31 19:44
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class partitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.print(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String S) {
        int[] chars = new int[26];
        for (int i = 0; i < S.length(); i++) {
            chars[S.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<Integer>();
        int start = 0;
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, chars[S.charAt(i) - 'a']);
            if (i == j){
                list.add(i - start +1);
                start = i+1;
            }
        }
        
        return list;
    }
}
