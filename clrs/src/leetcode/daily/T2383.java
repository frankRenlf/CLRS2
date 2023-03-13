package leetcode.daily;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/3/13 9:48
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = Arrays.stream(energy).sum();
        int add = 0;
        for (int j : experience) {
            if (j >= initialExperience) {
                int sub = j - initialExperience + 1;
                add += sub;
                initialExperience += sub;
            }
            initialExperience += j;
        }
        if (initialEnergy <= sum) {
            add += sum - initialEnergy + 1;
        }
        return add;
    }
}
