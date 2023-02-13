package study.nathan_algo_study.week47;

/**
 * 문제이름 : Wildcard Matching
 * 링크 : https://leetcode.com/problems/wildcard-matching/
 */

public class leetcode_44 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[pLen][sLen] = true;

        for (int i = pLen - 1; i >= 0; i--) {
            if (p.charAt(i) == '*')
                dp[i][sLen] = dp[i + 1][sLen];
        }

        for (int i = pLen - 1; i >= 0; i--) {
            for (int j = sLen - 1; j >= 0; j--) {
                if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else if (p.charAt(i) == '*')
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
}

/*

 */
