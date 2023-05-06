package leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/5/6 7:54
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description : medium
 */
public class T1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        if (n % 5 != 0) return -1;
        Map<Character, Integer> map = new HashMap<>() {{
            put('c', 0);
            put('r', 1);
            put('o', 2);
            put('a', 3);
            put('k', 4);
        }};
        int[] cnt = new int[4];
        int cur = 0;
        int sum = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            int pos = map.get(c);
            if (pos == 0) {
                cnt[pos]++;
                cur++;
                sum = Math.max(sum, cur);
            } else {
                if (cnt[pos - 1] == 0) return -1;
                cnt[pos - 1]--;
                if (pos == 4) {
                    cur--;
                } else {
                    cnt[pos]++;
                }
            }
        }
        if (cur > 0) return -1;
        return sum;
    }
}
