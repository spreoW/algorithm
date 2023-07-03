package greedy;

/**
 * @author :wangq
 * @date : 2023/6/30 16:22
 * 122. 买卖股票的最佳时机 II https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,1};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length == 1 || prices.length == 0){
            return 0;
        }
        if(prices.length == 2){
            return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        }
        // 7, 1, 5, 3, 6, 4
        int buy = 0;
        int sell = 1;
        int amount = 0;
        while (sell < prices.length) {
            if (prices[buy] > prices[sell]) {
                buy++;
                sell++;
                continue;
            }
            if (sell + 1 < prices.length) {
                if (prices[sell] > prices[sell + 1]) {
                    // 卖了再买
                    amount = amount - prices[buy] + prices[sell];
                    buy = sell + 1;
                    sell = sell + 2;
                } else {
                    sell++;
                }
            }else{
                return amount - prices[buy] + prices[sell];
            }
        }
        return amount;
    }
}
