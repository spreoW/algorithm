package greedy;

/**
 * @author :wangq
 * @date : 2023/6/30 17:35
 * 跳跃游戏 II https://leetcode.cn/problems/jump-game-ii/
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 输入:nums = [2,3,1,1,4]
 * 输出: 2
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        //输入:nums = [2,3,1,1,4]
        // 输出: 2
        int length = nums.length;
        int count = 0;
        int maxPosition = 0;
        int end = 0;
        for (int i = 0; i < length - 1; i++) {
            if (maxPosition < nums[i] + i) {
                maxPosition = nums[i] + i;
            }
            if (i == end) {
                end = maxPosition;
                count++;
            }
        }
        return count;
    }
}
