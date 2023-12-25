import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 0);
        dp[s.length()] = 1;
        for(int start = s.length() - 1; start >= 0; start--) {
            if (s.charAt(start) == '0') {
                dp[start] = 0;
            } else if (start + 1 < s.length() && Integer.parseInt(s.substring(start, start + 2)) <= 26) {
                dp[start] = dp[start + 1] + dp[start + 2];
            } else {
                dp[start] = dp[start + 1];
            }
        }
        return dp[0];
    }
}