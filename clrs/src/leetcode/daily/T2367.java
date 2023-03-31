package leetcode.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/3/31 22:02
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description : simple work in hospital
 */
public class T2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            set.add(x);
        }
        int ans = 0;
        for (int x : nums) {
            if (set.contains(x + diff) && set.contains(x + 2 * diff)) {
                ans++;
            }
        }
        return ans;
    }
}
