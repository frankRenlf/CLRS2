package leetcode.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/16 11:40
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description : calculate the max length of an increasing array in nums array.
 */
public class T1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        int sub = Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt();
        int[][] dp = new int[n][sub * 2 + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + sub;
                dp[i][d] = dp[j][d] + 1;
                max = Math.max(max, dp[i][d]);
            }
        }
        return max + 1;
    }
}
