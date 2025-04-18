import java.io.*;
import java.util.*;

class Main {
    static char[] arr;
    static int N;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        N = arr.length;
    }

    static void solve() {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < N; i++) {            
            if(stack.size() < 3) {
                stack.add(arr[i]);
            } else {
                if(arr[i] == 'P'
                   && stack.elementAt(stack.size() - 1) == 'A'
                   && stack.elementAt(stack.size() - 2) == 'P'
                   && stack.elementAt(stack.size() - 3) == 'P') {
                    stack.pop();
                    stack.pop();
                } else {
                    stack.add(arr[i]);
                }
            }
        }

        if(stack.isEmpty() || (stack.size() == 1 && stack.peek() == 'P')) {
            System.out.print("PPAP");
        } else {
            System.out.print("NP");
        }
    }
}


/*
p = ppap
ppap
1. ppap pap
2. p ppap ap
3. ppa ppap
*/
