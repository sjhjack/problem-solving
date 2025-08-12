import java.io.*;
import java.util.*;

class Main {
    static int N, M, T, K;
    static Point[] arr;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Point[T];

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Point(x, y);
        }
    }

    static void solve() {
        int X = 0;
        int Y = 0;
        int ans = 0;

        for(int i = 0; i < T; i++) {
            for(int j = 0; j < T; j++) {
                // 좌표의 x, y 기준으로 경계선 잡기
                int x = arr[i].x + K > N ? N - K : arr[i].x;
                int y = arr[j].y + K > M ? M - K : arr[j].y;
                int count = 0;

                // 정사각형에 포함되는 좌표 개수 구하기
                for(int k = 0; k < T; k++) {
                    if(x <= arr[k].x && arr[k].x <= x + K &&
                      y <= arr[k].y && arr[k].y <= y + K) {
                        count++;
                      }
                }

                if(count > ans) {
                    ans = count;
                    X = x;
                    Y = y + K;
                }
            }
        }

        System.out.print(X + " " + Y + "\n" + ans);
    }
}
