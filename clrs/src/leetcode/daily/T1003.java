package leetcode.daily;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/5/3 9:29
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1003 {
    public boolean isValid(String s) {
        int n = s.length();
        int k = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                k++;
            }
            if (c == 'c') {
                k--;
                b = 0;
            }
            if (c == 'b') {
                b = b == 0 ? 1 : 0;
            }
            if (k < b) return false;
        }
        return k == 0;
    }
}
