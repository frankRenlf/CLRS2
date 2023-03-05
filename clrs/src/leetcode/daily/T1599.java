package leetcode.daily;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/3/5 9:39
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = -1;
        int maxProfit = 0;
        int totalProfit = 0;
        int operations = 0;
        int customersCount = 0;
        int n = customers.length;
        for (int customer : customers) {
            operations++;
            customersCount += customer;
            int curCustomers = Math.min(customersCount, 4);
            customersCount -= curCustomers;
            totalProfit += boardingCost * curCustomers - runningCost;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                ans = operations;
            }
        }
        if (customersCount == 0) {
            return ans;
        }
        int profitEachTime = boardingCost * 4 - runningCost;
        if (profitEachTime <= 0) {
            return ans;
        }
        int fullTimes = customersCount / 4;
        totalProfit += profitEachTime * fullTimes;
        operations += fullTimes;
        if (totalProfit > maxProfit) {
            maxProfit = totalProfit;
            ans = operations;
        }
        int remainingCustomers = customersCount % 4;
        int remainingProfit = boardingCost * remainingCustomers - runningCost;
        totalProfit += remainingProfit;
        if (totalProfit > maxProfit) {
            maxProfit = totalProfit;
            operations++;
            ans++;
        }
        return ans;
    }
}
