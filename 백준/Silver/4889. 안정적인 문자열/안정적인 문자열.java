import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int testCase = 1;
        String s = "";

        while((s = br.readLine()).charAt(0) != '-') {
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '{') {
                    stack.add('{');
                } else {
                    if(stack.isEmpty()) {
                        stack.add('{');
                        count++;
                    } else {
                        stack.pop();
                    }
                }
            }

            count += stack.size() / 2;

            ans.append(testCase++).append(". ").append(count).append("\n");
        }

        System.out.print(ans);
    }
}