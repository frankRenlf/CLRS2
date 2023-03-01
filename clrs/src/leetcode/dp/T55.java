package leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/1 10:45
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1)return true;
        int[] dp = new int[n + 1];
        int maxLen = 0;
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] >= i) {
                dp[i] = Math.max(dp[i - 1], nums[i] + i);
                if (dp[i] >= n-1) {
                    return true;
                }
            }
        }
        return false;
    }

}
