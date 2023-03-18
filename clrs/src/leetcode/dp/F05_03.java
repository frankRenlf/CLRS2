package leetcode.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/18 11:07
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class F05_03 {

    public int reverseBits(int num) {
        int max = 0;
        int reverse = 0;
        int current = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                current++;
                reverse++;
            } else {
                reverse = current + 1;
                current = 0;
            }
            if (reverse > max) max = reverse;
            num >>= 1;
        }
        return max;
    }

}
