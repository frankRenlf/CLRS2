package leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/17 11:08
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class O42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int ret = nums[0];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
            ret = Math.max(ret, dp[i + 1]);
        }
        return ret;
    }
}
