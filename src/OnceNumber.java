import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class OnceNumber {
    public static int main(String[] args) {
        int[] nums = new int[]{2,2,1};
        Set set = new HashSet();
        for(int n1: nums){
            if(!set.contains(n1)){
                set.add(n1);
            } else {
                set.remove(n1);
            }
        }
        for (Object i : set){
            return (Integer)i;
        }
        return 0;
    }
}
