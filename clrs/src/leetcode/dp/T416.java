package leetcode.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/25 11:02
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T416 {
    public boolean canPartition_subarray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int half = sum / 2;
        int l = 0, r = 0; // 0,l-1 l,r-1 r,n-1
        int cur = 0;
        while (l < n && r <= n) {
            if (cur < half) {
                if(r==n)return false;
                r++;
                cur += nums[r - 1];
            } else if (cur > half) {
                cur -= nums[l];
                l++;
            } else {
                return true;
            }
        }
        return false;
    }
}
