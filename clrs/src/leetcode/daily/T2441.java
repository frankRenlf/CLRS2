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
 * @createTime : 2023/5/13 7:36
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description : easy
 */
public class T2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ret = 0;
        for (int el :
                nums) {
            if (set.contains(-el)) {
                ret = Math.max(ret, Math.abs(el));
            } else {
                set.add(el);
            }
        }
        return ret;
    }
}
