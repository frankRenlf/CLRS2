package leetcode.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/5/2 8:16
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description : medium
 */
public class T970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        int val1 = 1;
        for (int i = 0; i < 21; i++) {
            int val2 = 1;
            for (int j = 0; j < 21; j++) {
                int val = val1 + val2;
                if (val <= bound) {
                    set.add(val);
                } else {
                    break;
                }
                val2 *= y;
            }
            if (val1 >= bound) {
                break;
            }
            val1 *= x;
        }
        return new ArrayList<>(set);
    }
}
