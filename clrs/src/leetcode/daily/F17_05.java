package leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/3/11 9:49
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class F17_05 {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                int pos = map.get(sum);
                if (i - pos > maxLength) {
                    start = pos + 1;
                    maxLength = i - pos;
                }
            } else {
                map.put(sum, i);
            }
        }
        String[] ans = new String[maxLength];
        System.arraycopy(array, start, ans, 0, maxLength);
        return ans;
    }
}
