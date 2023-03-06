package leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/6 14:36
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 0 buy 1 sell 2 freeze
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]), dp[i - 1][2]);
            dp[i][2] = dp[i - 1][1];
        }
        return dp[n - 1][1];
    }
}
