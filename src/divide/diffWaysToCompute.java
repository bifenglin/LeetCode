package divide;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 有序数组中的单一元素
 * @author: maple
 * @create: 2020-04-04 17:12
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 * <p>
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class diffWaysToCompute {
    public static void main(String[] args) {
        String input = "2*3-4*5";
        List<Integer> list = diffWaysToCompute(input);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int index = 0;
        int num = 0;
        while (index < input.length() && !isOption(input.charAt(index))){
            num = num * 10 + (input.charAt(index) - '0');
            index++;
        }

        if (index == input.length()){
            res.add(num);
            return res;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!isOption(input.charAt(i))){
                continue;
            }
            List<Integer> list = diffWaysToCompute(input.substring(0, i));
            List<Integer> list1 = diffWaysToCompute(input.substring(i+1, input.length()));
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list1.size(); k++) {
                    Integer re = caculate(list.get(j), list1.get(k), input.charAt(i));
                    res.add(re);
                }
            }
        }
        return res;

    }

    static boolean isOption(char c){
        return c == '+' || c == '*' || c == '-';
    }

    static int caculate(int num1, int num2, char op){
        if (op == '+'){
            return num1 + num2;
        }
        if (op == '-'){
            return num1 - num2;
        }
        if (op == '*'){
            return num1 * num2;
        }
        return 0;
    }

}
