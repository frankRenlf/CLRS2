package leetcode.daily;

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
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[j]=Math.max(dp[j],dp[i]+1);
                }
            }
        }
    }
}
