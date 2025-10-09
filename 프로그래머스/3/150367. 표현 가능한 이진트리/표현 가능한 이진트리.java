import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            // 포화이진트리 높이
            int height = (int)(Math.log(binary.length())/Math.log(2));
            // 필요한 더미노드 개수
            int dummyCnt = (int)Math.pow(2, height + 1) - 1 - binary.length();
            String s = "";
            
            // 더미 노드를 앞에 더하기
            // (뒤에 더하면 숫자가 달라진다 -> 01 = 001, 01 != 010)
            for(int j = 0; j < dummyCnt; j++) {
                s += "0";
            }
            
            char[] arr = (s + binary).toCharArray();
            
            answer[i] = checkTree(arr, arr.length/2, (arr.length/2 + 1)/2, false) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean checkTree(char[] arr, int index, int nextGap, boolean zeroFlag) {
        // 중간에 더미 노드가 나오면, 자식 노드는 모두 더미 노드가 나와야 함
        if(zeroFlag && arr[index] == '1') {
            return false;
        } else if(!zeroFlag && arr[index] == '0') {
            zeroFlag = true;
        }
        
        // 문제 없이 리프 노드 도달
        if(nextGap == 0) {
            return true;
        }
        
        return checkTree(arr, index - nextGap, nextGap / 2, zeroFlag)
            && checkTree(arr, index + nextGap, nextGap / 2, zeroFlag);
    }
}

























