package leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/10 15:03
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T799 {
    public double champagneTower2(int k, int n, int m) {
        double[][] f = new double[n + 1][n + 1];
        f[0][0] = k;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (f[i][j] <= 1) continue;
                f[i + 1][j] += (f[i][j] - 1) / 2;
                f[i + 1][j + 1] += (f[i][j] - 1) / 2;
            }
        }
        return Math.min(f[n][m], 1);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= query_glass; j++) {
                if (j > 0) {
                    dp[i][j] += (dp[i - 1][j - 1] - 1) / 2;
                }
                if (j < i) {
                    dp[i][j] += (dp[i - 1][j] - 1) / 2;
                }
            }
        }
        return dp[query_row][query_glass] <= 0 ? 0 : dp[query_row][query_glass] % 1;
    }
}
