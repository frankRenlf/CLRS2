package leetcode.daily;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/3/6 9:50
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1653 {
    public int minimumDeletions(String s) {
        int leftb = 0, righta = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                righta++;
            }
        }
        int res = righta;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                righta--;
            } else if (s.charAt(i) == 'b') {
                leftb++;
            }
            res = Math.min(leftb, righta);
        }
        return res;
    }
}
