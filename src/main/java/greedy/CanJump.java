package greedy;

/**
 * @author :wangq
 * @date : 2023/6/29
 * 55. 跳跃游戏 https://leetcode.cn/problems/jump-game/
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class CanJump {
    /**
     * 跳跃游戏
     * https://leetcode.cn/problems/jump-game/
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * [2,3,1,1,4]
     * [3,2,1,0,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(canJump(nums));

    }

    public static boolean canJump(int[] nums) {
        // * [2,3,1,1,4]
        // [3,4,0,1,0,0,3,0]
        // * [3,2,1,0,4]
        int max = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[max] - (j - max) >= 0) {
                max = nums[max] - (j - max) >= nums[j] ? max : j;
                if (nums[max] + max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
