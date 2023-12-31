class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            int oneDigit = Character.getNumericValue(s.charAt(i - 1));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (oneDigit != 0) {
                dp[i] += dp[i - 1];
            }
            if (10 <= twoDigits && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}