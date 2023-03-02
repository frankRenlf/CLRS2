package leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/2 9:27
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T05_02 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0) {
            num *= 2;
            int digit = (int) num;
            sb.append(digit);
            num -= digit;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }
}
