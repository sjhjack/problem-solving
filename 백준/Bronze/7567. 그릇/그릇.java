import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        
        char[] tmp = br.readLine().toCharArray();
        int ans = 10;
        stack.add(tmp[0]);

        for(int i = 1; i < tmp.length; i++) {
            if(stack.peek() != tmp[i]) {
                ans += 10;
            } else {
                ans += 5;
            }

            stack.add(tmp[i]);
        }

        System.out.print(ans);
    }
}