package Lv2;

public class 멀리뛰기 {
    public static void main(String[] args) {
        long result = solution(4);
        assert result == 5;
    }
    private static long solution(int n) {
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        return dp[n];
    }
}
