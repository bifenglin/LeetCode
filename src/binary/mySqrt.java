package binary;

/**
 * @program: LeetCode
 * @description: x 的平方根
 * @author: maple
 * @create: 2020-04-04 16:12
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class mySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    static int mySqrt(int x) {
        if (x <= 2) return 1;
        int l = 1;
        int r = x / 2;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long res = (long) m * m;
            if (res == x) {
                return m;
            } else if (res > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
