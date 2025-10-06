import java.io.*;
import java.util.*;

class Solution {    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> ansList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int targetDate = calcDate(today);
        
        for(int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int startDate = calcDate(privacy[0]);
            int month = map.get(privacy[1]);
            
            if(startDate + month * 28 <= targetDate) {
                ansList.add(i + 1);
            }
        }
        
        return ansList.stream().mapToInt(i -> i).toArray();
    }
    
    private int calcDate(String date) {
        String[] arr = date.split("\\.");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}