package leetcode.daily;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/3/9 9:29
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T2379 {
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE, cur = 0;
        int n = blocks.length();
        for (int i = 0, j = 0; i <= n - k; i++) {
            if (j == n) {
                break;
            }
            while (j <= i + k - 1 && j < n) {
                if (blocks.charAt(j) == 'W') {
                    cur++;
                }
                j++;
            }
            min = Math.min(min, cur);
            if (blocks.charAt(i) == 'W') {
                cur--;
            }
        }
        return min;
    }
}
