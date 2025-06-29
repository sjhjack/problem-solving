import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arrA = br.readLine().toCharArray();
        char[] arrB = br.readLine().toCharArray();

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < 8; i++) {
            queue.add(arrA[i] - '0');
            queue.add(arrB[i] - '0');
        }

        for(int i = 14; i >= 1; i--) {
            int a = 0;
            int b = queue.poll();

            for(int j = i; j >= 0; j--) {
                a = b;
                b = queue.poll();

                queue.add((a + b) % 10);
            }
        }

        int ans = queue.poll() * 10 + queue.poll();
        System.out.print(ans < 10 ? "0"+ans : ans);
    }
}
