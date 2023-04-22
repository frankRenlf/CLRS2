package leetcode.daily;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/22 8:26
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int ret = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int sub = nums[j] - nums[i] + 500;
                dp[i][sub] = Math.max(dp[i][sub], dp[j][sub] + 1);
                ret = Math.max(ret, dp[i][sub]);
            }
        }
        return ret + 1;
    }
}
