package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/14 16:18
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1025 {
    public boolean divisorGame(int n) {
        int end = n / 2;
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;
        List<Integer> div = new ArrayList<>();
        for (int i = 1; i <= end; i++) {
            if (n % i == 0) {
                div.add(i);
            }
        }
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (div.contains(j) && dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
