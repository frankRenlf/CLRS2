package leetcode.daily;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/1 6:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T831 {
    public String maskPII(String s) {
        if (s.contains("@")) {
            return dealEmail(s);
        }
        return dealNumber(s);
    }

    private String dealNumber(String s) {
        return null;
    }

    private String dealEmail(String s) {
        s = s.toLowerCase(Locale.ROOT);
        return s.charAt(0) + "*****" + s.substring(s.indexOf("@") - 1);
    }

    static T831 t831 = new T831();

    public static void main(String[] args) {
        System.out.println(t831.maskPII("AB@qq.com"));
    }
}
