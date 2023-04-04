package leetcode.daily;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/4 8:44
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1000 {
    static final int INF = 0x3f3f3f3f;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], INF);
        }
        int[] sum = new int[n];

        for (int i = 0, s = 0; i < n; i++) {
            d[i][i] = 0;
            s += stones[i];
            sum[i] = s;
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l < n && l + len - 1 < n; l++) {
                int r = l + len - 1;
                for (int p = l; p < r; p += k - 1) {
                    d[l][r] = Math.min(d[l][r], d[l][p] + d[p + 1][r]);
                }
                if ((r - l) % (k - 1) == 0) {
                    d[l][r] += sum[r] - (l == 0 ? 0 : sum[l - 1]);
                }
            }
        }
        return d[0][n - 1];
    }
}
