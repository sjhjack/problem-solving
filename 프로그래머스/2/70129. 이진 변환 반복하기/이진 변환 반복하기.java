import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        char[] binary = s.toCharArray();
        int zeroCnt = 0;
        int convertCnt = 0;
        
        while(true){
            if(binary.length == 1 && binary[0] == '1') break;
            
            Arrays.sort(binary);
            
            int idx = 0;
            
            for(int i = 0; i < binary.length; i++){
                if(binary[i] == '1'){
                    break;
                }
                idx++;
            }
            
            int len = binary.length - idx;
            
            zeroCnt += idx;
            binary = Integer.toBinaryString(len).toCharArray();
            convertCnt++;
        }
        
        return new int[] {convertCnt, zeroCnt};
    }
}