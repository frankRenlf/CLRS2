package leetcode.daily;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/26 8:57
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        return Math.max(order(nums, n, firstLen, secondLen), order(nums, n, secondLen, firstLen));
    }

    private int order(int[] nums, int n, int len1, int len2) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < len1; i++) {
            dp1[len1 - 1] += nums[i];
        }
        int sub = dp1[len1 - 1];
        for (int i = len1; i < n - len2; i++) {
            sub += nums[i] - nums[i - len1];
            dp1[i] = Math.max(dp1[i - 1], sub);
        }
        for (int i = n - 1; i > n - len2 - 1; i--) {
            dp2[n - len2] += nums[i];
        }
        sub = dp2[n - len2];
        for (int i = n - len2 - 1; i >= len1; i--) {
            sub += nums[i] - nums[i + len2];
            dp2[i] = Math.max(dp2[i + 1], sub);
        }
        int sum = 0;
        for (int i = len1 - 1; i < n - len2; i++) {
            sum = Math.max(dp1[i] + dp2[i + 1], sum);
        }
        return sum;
    }

    static T1031 t1031 = new T1031();

    public static void main(String[] args) {
        System.out.println(t1031.maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
    }
}
