package leetcode.daily;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/5/1 9:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int ret = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{headID, 0});
        while (!queue.isEmpty()) {
            int[] leaf = queue.poll();
            int k = leaf[0], depth = leaf[1];
            if (!map.containsKey(k)) {
                ret = Math.max(ret, depth);
            } else {
                for (int i :
                        map.get(k)) {
                    queue.offer(new int[]{i, depth + informTime[k]});
                }
            }
        }
        return ret;
    }

    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        return dfs(map, headID, informTime);
    }

    private int dfs(Map<Integer, List<Integer>> map, int k, int[] informTime) {
        int ret = 0;
        for (int i :
                map.getOrDefault(k, new ArrayList<>())) {
            ret = Math.max(ret, dfs(map, i, informTime) + informTime[k]);
        }
        return ret;
    }
}
