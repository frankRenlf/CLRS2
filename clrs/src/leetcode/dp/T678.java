package leetcode.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.dp
 * @createTime : 2023/3/10 10:53
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T678 {
    public boolean checkValidString(String s) {
        int n = s.length();
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> astar = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            } else if (s.charAt(i) == '*') {
                astar.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!astar.isEmpty()) {
                    astar.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left.isEmpty() && !astar.isEmpty()) {
            int leftIndex = left.pop();
            int astarIndex = astar.pop();
            if (leftIndex > astarIndex) {
                return false;
            }
        }
        return left.isEmpty();
    }
}
