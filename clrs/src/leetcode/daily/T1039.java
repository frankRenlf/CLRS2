package leetcode.daily;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/2 8:49
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description : two methods, one dfs , one dp
 */
public class T1039 {
    private int[] v;
    private int[][] memo;

    public int minScoreTriangulation_dfs(int[] values) {
        v = values;
        int n = v.length;
        memo = new int[n][n];
        for (int i = 0; i < n; ++i)
            Arrays.fill(memo[i], -1); // -1 表示没有访问过
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i + 1 == j) return 0; // 只有两个点，无法组成三角形
        if (memo[i][j] != -1) return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) // 枚举顶点 k
            res = Math.min(res, dfs(i, k) + dfs(k, j) + v[i] * v[j] * v[k]);
        return memo[i][j] = res;
    }

    public int minScoreTriangulation_dp(int[] v) {
        int n = v.length;
        int[][] f = new int[n][n];
        for (int i = n - 3; i >= 0; --i)
            for (int j = i + 2; j < n; ++j) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k)
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j] + v[i] * v[j] * v[k]);
            }
        return f[0][n - 1];
    }
}
