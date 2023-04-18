package leetcode.daily;

import leetcode.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/18 14:02
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1026 {

    public int maxAncestorDiff_fast(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mi, int ma) {
        if (root == null) {
            return 0;
        }
        int diff = Math.max(Math.abs(root.val - mi), Math.abs(root.val - ma));
        mi = Math.min(mi, root.val);
        ma = Math.max(ma, root.val);
        diff = Math.max(diff, dfs(root.left, mi, ma));
        diff = Math.max(diff, dfs(root.right, mi, ma));
        return diff;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public int maxAncestorDiff_origin(TreeNode root) {
        sub(root.val, root.val, root);
        return pq.poll();
    }

    private void sub(int maxVal, int smallVal, TreeNode root) {
        if (root == null) {
            return;
        }
        maxVal = Math.max(maxVal, root.val);
        smallVal = Math.min(smallVal, root.val);
        pq.add(Math.abs(maxVal - smallVal));
        sub(maxVal, smallVal, root.left);
        sub(maxVal, smallVal, root.right);
    }

    static T1026 t1026 = new T1026();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(-1);
        root.right = new TreeNode(0);
        System.out.println(t1026.maxAncestorDiff(root));
    }
}
