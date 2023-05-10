package leetcode.daily;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/5/10 8:17
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description : medium
 */
public class T1015 {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0)
            return -1;
        int i = 1;
        for (int n = 1; n % K != 0; i++) {
            n %= K;
            n = n * 10 + 1;
        }
        return i;
    }
}
