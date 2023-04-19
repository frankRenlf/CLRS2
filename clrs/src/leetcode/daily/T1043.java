package leetcode.daily;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/19 19:58
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1043 {
    /**
     * 方法一：动态规划
     * <p>
     * 题目：把 arr 分成多个连续子数组，每个子数组的长度不能超过k，每个子数组所有元素变为其中最大值，求分割完后所有子数组的元素和的最大值
     * <p>
     * 思路与算法
     * <p>
     * 从 不超过 k 入手，不超过 k，也就是长度可以是 1、2、3、...、k
     * <p>
     * 那么 对于 arr[0...n-1]，
     * 可以考虑最后一个子数组的长度分别为 1、2、、3、...、k
     * 对应的起始位置j分别为      i、i-1、i-2、...、i-k+1
     * 那么子数组的最后元素和为   长度 * 最大值 = (n-1 - j + 1) * max(arr[j...n-1])，取所有长度下的最大值
     * 至于剩余部分，arr[0...j-1] 就是一个子问题求解了
     * <p>
     * 因此，设 d[i] 为以 i 结尾时（即 arr[0...i]）分割后的最大和，最后只需要返回 dp[n-1]
     * 递推：
     * dp[i] = max(dp[j-1] + (i-j+1) * max(arr[j...i]))，[j, i] 是最后一个子数组，长度为 i-j+1，不能超过k，所以 j>=i-k+1
     * 关于这个 max(arr[j...i]) 可以通过倒序枚举j的方式 避免for循环来统计
     * j是最后一段子数组的起始位置，如果 倒序遍历 j [i...i-k+1]，用 max 记录每个 不同 j 时 [j...i] 范围内的最大值
     * 倒序遍历每个 j，
     * max = max(max, arr[j])，就能直接得到 [j...i] 范围内的最大值
     * 然后，dp[i] = max(dp[j-1] + (i-j+1) * max)
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // 设 d[i] 为以 i 结尾时（即 arr[0...i]）分割后的最大和，最后只需要返回 dp[n-1]
        int[] dp = new int[n];
        // 递推，i 是结束位置
        for (int i = 0; i < n; ++i) {
            // 倒序枚举最后一个子数组的起点，[j...i] 长度不能k
            // 在倒序枚举j的过程中 更新 max，得到 arr[j...i]内的最大值
            int max = arr[i];
            // 1 <= len([j...i] = i-j+1) <= k
            for (int j = i; j >= Math.max(i - k + 1, 0); --j) {
                // 当前 arr[j...i] 内最大值
                max = Math.max(max, arr[j]);
                // 为以 i 结尾时（即 arr[0...i]）分割后的最大和 = 最后一段子数组[j...i]的最大和 + 前面[0...j-1]的最大分割和
                // 注意不要越界
                dp[i] = Math.max(dp[i], (j > 0 ? dp[j - 1] : 0) + (i - j + 1) * max);
            }
        }
        // 返回
        return dp[n - 1];
    }
}
