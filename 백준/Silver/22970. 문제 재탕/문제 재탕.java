import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1) {
            System.out.print(1);
            return;
        }

        int max = 1;
        int length = 1;
        boolean up = arr[0] < arr[1] ? true : false;
        boolean down = arr[0] > arr[1] ? true : false;

        for(int i = 1; i < N; i++) {
            if(arr[i - 1] < arr[i]) {
                if(up) {
                    // 계속 올라가는 경우
                    length++;
                    max = Math.max(max, length);
                } else if(down) {
                    // 내려가다가 올라가는 경우 (새로 시작)
                    max = Math.max(max, length);
                    length = 2;
                    up = true;
                    down = false;
                } else {
                    // 평지였을 경우
                    up = true;
                    length = 2;
                }
            } else if(arr[i - 1] > arr[i]) {
                if(up) {
                    // 올라가다가 내려가는 경우 (정상 도착)
                    up = false;
                    down = true;
                    length++;
                } else if(down) {
                    // 계속 내려가는 경우
                    length++;
                } else {
                    down = true;
                    length = 2;
                }
                
                max = Math.max(max, length);
            } else if(arr[i - 1] == arr[i]) {
                // 평지일 경우
                length = 1;
                up = false;
                down = false;
            }
        }

        System.out.print(max);
    }
}
