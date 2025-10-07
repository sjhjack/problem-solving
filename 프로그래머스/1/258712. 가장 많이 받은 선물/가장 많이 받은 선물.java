import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> indexMap = new HashMap<>();
        int[] giveCnt = new int[friends.length];
        int[] takeCnt = new int[friends.length];
        int[] giftScore = new int[friends.length];
        int[][] arr = new int[friends.length][friends.length];
        int answer = 0;
        
        for(int i = 0; i < friends.length; i++) {
            indexMap.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            int giver = indexMap.get(gift[0]);
            int taker = indexMap.get(gift[1]);
            
            giveCnt[giver]++;
            takeCnt[taker]++;
            arr[giver][taker]++;
        }
        
        for(int i = 0; i < friends.length; i++) {
            giftScore[i] = giveCnt[i] - takeCnt[i];
        }
        
        for(int i = 0; i < friends.length; i++) {
            int count = 0;
            
            for(int j = 0; j < friends.length; j++) {
                if(i == j) {
                    continue;
                }
                
                if(arr[i][j] > arr[j][i]) {
                    count++;
                } else if(arr[i][j] == arr[j][i] && giftScore[i] > giftScore[j]) {
                    count++;
                }
            }
            
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}
