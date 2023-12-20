class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {
        var minSum = Integer.MAX_VALUE
        var ans = money
        for (i in prices.indices) {
            for (j in prices.indices) {
                if (i == j) continue
                val sum = prices[i] + prices[j]
                if (money < sum) continue
                if (minSum > sum) {
                    minSum = sum
                    ans = money - (prices[i] + prices[j])
                }
            }
        }
        return ans
    }
}