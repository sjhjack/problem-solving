import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        while(true) {
            String s = br.readLine();
            
            if(s.equals("*")) break;
            
            char[] arr = s.toCharArray();
            Set<Character> set = new HashSet<>();
            
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != ' ') {
                    set.add(arr[i]);
                }
            }
            
            if(set.size() == 26) {
                ans.append("Y\n");
            } else {
                ans.append("N\n");
            }
        }
        
        System.out.print(ans);
    }
}