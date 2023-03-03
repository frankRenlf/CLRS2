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
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }

    static T1487 t1487 = new T1487();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(t1487.getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"})));
//        System.out.println("123".substring(1,3));
    }
}
