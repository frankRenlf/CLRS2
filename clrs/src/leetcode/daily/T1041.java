package leetcode.daily;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/11 9:01
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        int x = 0, y = 0;
        int n = instructions.length();
        for (int idx = 0; idx < n; idx++) {
            char instruction = instructions.charAt(idx);
            if (instruction == 'G') {
                x += direct[directIndex][0];
                y += direct[directIndex][1];
            } else if (instruction == 'L') {
                directIndex += 3;
                directIndex %= 4;
            } else {
                directIndex++;
                directIndex %= 4;
            }
        }
        return directIndex != 0 || (x == 0 && y == 0);
    }
}
