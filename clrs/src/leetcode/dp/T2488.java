package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/16 10:54
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2488 {

    public int countSubarrays(int[] nums, int k) {
        int pos = 0, n = nums.length;
        while (nums[pos] != k) ++pos;

        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        // i=pos 的时候 x 是 0，直接记到 cnt 中，这样下面不是大于 k 就是小于 k
        cnt.put(0, 1);
        for (int i = pos - 1, x = 0; i >= 0; --i) { // 从 pos-1 开始累加 x
            x += nums[i] < k ? 1 : -1;
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        // i=pos 的时候 x 是 0，直接加到答案中，这样下面不是大于 k 就是小于 k
        int ans = cnt.get(0) + cnt.getOrDefault(-1, 0);
        for (int i = pos + 1, x = 0; i < n; ++i) { // 从 pos+1 开始累加 x
            x += nums[i] > k ? 1 : -1;
            ans += cnt.getOrDefault(x, 0) + cnt.getOrDefault(x - 1, 0);
        }
        return ans;
    }


}
