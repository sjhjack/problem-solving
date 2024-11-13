import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for(int j = 0; j < arr.length; j++) {
                if(stack.isEmpty()) {
                    stack.add(arr[j]);
                } else {
                    if(stack.peek() == arr[j]) {
                        stack.pop();
                    } else {
                        stack.add(arr[j]);
                    }
                }
            }

            if(stack.isEmpty()) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}