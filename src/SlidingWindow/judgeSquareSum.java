package SlidingWindow;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-19 16:57
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: 3
 * 输出: False
 **/
public class judgeSquareSum {
    public static void main(String[] args) {
        System.out.print(judgeSquareSum(5));
    }
    public static boolean judgeSquareSum(int c) {
        if(c < 0)
            return false;

        int i =0;//双指针的左指针
        int j = (int) Math.sqrt(c);//双指针的右指针

        while(i <= j)
        {
            if(i*i == c - j*j)
                return true;
            else if(c - j*j < i*i)
                j--;
            else
                i++;
        }

        return false;
    }
}
