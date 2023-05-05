package leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/5/5 11:30
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description : easy
 */
public class T2432 {
    public int hardestWorker(int n, int[][] logs) {
        int len = logs.length;
        int[] cnt = new int[n];
        cnt[logs[0][0]] = logs[0][1];
        int ret = logs[0][0];
        for (int i = 1; i < len; i++) {
            cnt[logs[i][0]] = Math.max(logs[i][1] - logs[i - 1][1], cnt[logs[i][0]]);
            if (cnt[logs[i][0]] > cnt[ret]) {
                ret = logs[i][0];
            } else if (cnt[logs[i][0]] == cnt[ret]) {
                ret = Math.min(logs[i][0], ret);
            }
        }
        return ret;
    }
}
