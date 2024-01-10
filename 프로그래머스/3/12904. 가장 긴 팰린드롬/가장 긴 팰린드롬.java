class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        char[] arr = s.toCharArray();
        int len = s.length();
        int[][] dp = new int[len][len];
        
        for(int i = 0; i < len; i++) dp[i][i] = 1;
        
        for(int i = 0; i < len-1; i++){
            if(arr[i] == arr[i+1]){
                answer = 2;
                dp[i][i+1] = 2;
            }
        }
        
        for(int gap = 2; gap < len; gap++){
            for(int idx = 0; idx + gap < len; idx++){
                if(arr[idx] == arr[idx + gap] && dp[idx + 1][idx + gap - 1] > 0){
                    dp[idx][idx + gap] = dp[idx + 1][idx + gap - 1] + 2;
                    answer = Math.max(answer, dp[idx][idx + gap]);
                }
            }
        }

        return answer;
    }
}