package leetcode.dp;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/5 10:01
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][row];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] += triangle.get(i).get(j);
                if (i != row - 1) {
                    dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
