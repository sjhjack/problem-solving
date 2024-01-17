import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];;
        
        int N = n;
        int S = s;
        int cnt = 0;
        
        while(cnt < n && S / N > 0){
            answer[cnt++] = S / N;
            S -= S / N;
            N--;
        }
        
        if(cnt != n){
            answer = new int[]{-1};
        }
        
        return answer;
    }
}
