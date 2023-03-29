package leetcode.daily;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/3/29 12:20
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1641 {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        for (int j = 0; j < 5; ++j)
            dp[0][j] = j + 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 5; ++j) {
                dp[i][j] = dp[i - 1][j] + (j > 0 ? dp[i][j - 1] : 0);
            }
        }
        return dp[n - 1][4];
    }

}
