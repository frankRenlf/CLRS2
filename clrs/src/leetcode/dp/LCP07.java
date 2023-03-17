package leetcode.dp;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/17 13:43
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class LCP07 {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1; // 表示第0轮传递到编号为0的小朋友的总方案数
        for (int i = 1; i <= k; i++) {
            for (int[] r : relation) {
                dp[i][r[1]] += dp[i - 1][r[0]];
            }
        }
        return dp[k][n - 1];
    }

    public int numWays_bfs(int n, int[][] rs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] r : rs) {
            int a = r[0], b = r[1];
            Set<Integer> s = map.getOrDefault(a, new HashSet<>());
            s.add(b);
            map.put(a, s);
        }
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        while (!d.isEmpty() && k-- > 0) {
            int size = d.size();
            while (size-- > 0) {
                int poll = d.pollFirst();
                Set<Integer> es = map.get(poll);
                if (es == null) continue;
                for (int next : es) {
                    d.addLast(next);
                }
            }
        }
        int ans = 0;
        while (!d.isEmpty()) {
            if (d.pollFirst() == n - 1) ans++;
        }
        return ans;
    }

}
