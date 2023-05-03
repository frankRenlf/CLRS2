package leetcode.daily;

import java.util.Objects;
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
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description : medium
 */
public class T1003 {
    public boolean isValid(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            str.append(c);
            if (str.length() >= 3 && Objects.equals(str.substring(str.length() - 3), "abc")) {
                str.delete(str.length() - 3, str.length());
            }
        }
        return str.isEmpty();
    }
}
