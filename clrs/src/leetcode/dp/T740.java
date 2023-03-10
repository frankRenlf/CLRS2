package leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/10 14:34
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T740 {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[size - 1];
    }
}
