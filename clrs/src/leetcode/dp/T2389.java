package leetcode.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/17 10:26
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = binarySearch(pre, queries[i], n) - 1;
        }
        return ans;
    }

    private int binarySearch(int[] pre, int query, int n) {
        int left = 1, right = n + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (pre[mid] <= query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
