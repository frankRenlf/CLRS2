package leetcode.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/19 20:27
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T264 {
    public int nthUglyNumber(int n) {
        int[] pointer = new int[3];
        int[] pivot = new int[]{2, 3, 5};
        int[] nums = new int[3];
        int[] dp = new int[n + 1];
        Arrays.fill(nums, 1);
        for (int i = 1; i <= n; i++) {
            dp[i] = Arrays.stream(nums).min().getAsInt();
            for (int j = 0; j < 3; j++) {
                if (nums[j] == dp[i]) {
                    pointer[j]++;
                    nums[j] = dp[pointer[j]] * pivot[j];
                }
            }
        }
        return dp[n];
    }
}
