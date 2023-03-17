package leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/17 14:16
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class LCS01 {
    public int leastMinutes(int n) {
        int speed = 1;
        int cost = 0;
        while (n > 0) {
            if (speed >= n) {
                cost++;
                n -= speed;
            } else {
                cost++;
                speed *= 2;
            }
        }
        return cost;
    }
}
