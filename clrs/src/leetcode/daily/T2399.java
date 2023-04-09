package leetcode.daily;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/9 9:34
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T2399 {
    public boolean checkDistances(String s, int[] distance) {
        int[] generate = new int[26];
        Arrays.fill(generate, -1);
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            generate[pos] = generate[pos] == -1 ? i : i - generate[pos] - 1;
        }
        System.out.println(Arrays.toString(generate));
        for (int i = 0; i < 26; i++) {
            if (generate[i] != -1 && generate[i] != distance[i]) return false;
        }
        return true;
    }
    static T2399 t2399 = new T2399();

    public static void main(String[] args) {
        t2399.checkDistances("abaccb",new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }
}
