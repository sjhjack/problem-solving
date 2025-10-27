import java.io.*;
import java.util.*;

class Main {
    static int N, maxCount;
    static int[][] arr;
    static boolean[] isBroken;
    
    public static void main(String[] args) throws IOException {
        init();
        breakEgg(0, 0);
        System.out.print(maxCount);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        isBroken = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 내구도
            arr[i][1] = Integer.parseInt(st.nextToken());   // 무게
        }
    }

    static void breakEgg(int index, int breakCount) {
        if(index >= N) {
            maxCount = Math.max(maxCount, breakCount);
            return;
        }

        // 깨진 계란을 들었거나, 나머지가 모두 깨진 계란일 경우
        if(isBroken[index] || breakCount == N - 1) {
            breakEgg(index + 1, breakCount);
            return;
        }

        int count = 0;

        for(int i = 0; i < N; i++) {
            if(isBroken[i] || i == index) {
                continue;
            }

            count = 0;

            // 내구도 감소
            arr[index][0] -= arr[i][1];
            arr[i][0] -= arr[index][1];

            if(arr[index][0] <= 0) {
                isBroken[index] = true;
                count++;
            }
            if(arr[i][0] <= 0) {
                isBroken[i] = true;
                count++;
            }

            breakEgg(index + 1, breakCount + count);

            // 내구도 복구
            arr[index][0] += arr[i][1];
            arr[i][0] += arr[index][1];

            if(arr[index][0] > 0) {
                isBroken[index] = false;
            }
            if(arr[i][0] > 0) {
                isBroken[i] = false;
            }
        }
    }
}
