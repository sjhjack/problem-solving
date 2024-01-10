import java.io.*;
import java.util.*;

class Solution {    
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int work : works) {
            pq.add(work);
        }
        
        while(n > 0 && !pq.isEmpty()){
            int cur = pq.poll();
            
            n--;
            cur--;
            
            if(cur > 0){
                pq.add(cur);
            }
        }
        
        while(!pq.isEmpty()){
            long cur = (long)pq.poll();
            answer += cur * cur;
        }
        
        return answer;
    }
    
}