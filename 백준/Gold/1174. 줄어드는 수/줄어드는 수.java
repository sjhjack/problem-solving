import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Long> queue = new ArrayDeque<>();
        int digit = 2;
        int count = 10;
        
        if(N <= 10) {
            System.out.print(N - 1);
            return;
        }

        for(int i = 0; i < 10; i++) {
            queue.add((long)i);
        }

        // MAX : 10자리수인 9876543210까지 탐색
        // 사실 1023번째 수가 MAX이다.
        while(digit <= 10) {
            // digit 자리수 탐색
            for(int i = queue.size(); i > 0; i--) {
                long number = queue.poll();
                long last = number % 10;

                for(int j = 0; j < last; j++) {
                    queue.add(number * 10 + j);
                    count++;

                    if(count == N) {
                        System.out.print(number * 10 + j);
                        return;
                    }
                }
            }

            digit++;
        }

        System.out.print(-1);
    }
}
