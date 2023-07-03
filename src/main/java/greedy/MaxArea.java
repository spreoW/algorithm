package greedy;

/**
 * @author :wangq
 * @date : 2023/6/29
 *
 * https://leetcode.cn/problems/container-with-most-water/
 * 盛最多水的容器
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    /**
     * 端点奔赴
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        if (height.length == 1) {
            return 1;
        }
        int a = 0;
        int b = height.length - 1;
        int maxArea = 0;
        while (a < b) {
            maxArea = height[a] > height[b] ?
                    Math.max(maxArea, (b - a) * height[b--]) :
                    Math.max(maxArea, (b - a) * height[a++]);
        }
        return maxArea;
    }
}
