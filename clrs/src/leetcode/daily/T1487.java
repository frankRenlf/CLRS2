package leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/3/3 11:11
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        int n = names.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            int k = 0;
            if (name.contains("(")) {
                System.out.println();
                k = Integer.parseInt(name.substring(name.indexOf("(") + 1, name.length() - 1));
                name = name.substring(0, name.indexOf("(") - 1);
            }
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
                str[i] = name + "(" + map.get(name) + ")";
            } else {
                map.put(name, k);
                str[i] = name;
            }
        }
        return str;
    }
    static T1487 t1487 = new T1487();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(t1487.getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"})));
//        System.out.println("123".substring(1,3));
    }
}
