import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals(".")) {
                break;
            }

            char[] arr = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean no = false;

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '(' || arr[i] == '[') {
                    stack.add(arr[i]);
                } else if(arr[i] == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        no = true;
                        break;
                    }
                } else if(arr[i] == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        no = true;
                        break;
                    }
                }
            }

            if(no || !stack.isEmpty()) {
                ans.append("no\n");
            } else {
                ans.append("yes\n");
            }
        }

        System.out.print(ans);
    }
}