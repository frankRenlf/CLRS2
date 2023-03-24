package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/24 10:27
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T397 {


    public int integerReplacement(int n) {
        // dp[n]代表从n替换成1的最小次数
        // dp[1] = 0;
        // n是偶数
        // dp[n] = dp[n/2]
        // n是奇数 dp[n] = Math.min(dp[n-1],dp[n+1])
        //  dp[n] = Math.min(dp[(n-1)/2],dp[(n+1)/2])
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) dp[i] = dp[i / 2] + 1;
            else dp[i] = Math.min(dp[(i - 1) / 2] + 1, dp[(i + 1) / 2] + 1) + 1;
        }
        return dp[n];
    }

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int integerReplacement2(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement(n / 2));
            } else {
                memo.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return memo.get(n);
    }

}
