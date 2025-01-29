import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int cur = 1;

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            if(number == cur) {
                cur++;

                while(!stack.isEmpty() && stack.peek() == cur) {
                    stack.pop();
                    cur++;
                }
            } else {
                stack.add(number);
            }
        }

        if(!stack.isEmpty()) {
            System.out.print("Sad");
        } else {
            System.out.print("Nice");
        }
    }
}