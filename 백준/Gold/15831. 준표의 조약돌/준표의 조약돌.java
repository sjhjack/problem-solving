import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, B, W;
    private static char[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = br.readLine().toCharArray();
    }

    private static void solve() {
        int max = 0;
        int black = 0;
        int white = 0;
        int left = 0;
        int right = 1;

        if(arr[0] == 'B') {
            black++;
        } else {
            white++;
        }

        if(arr.length == 1) {
            if(black <= B && white >= W) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }

            return;
        }

        if(arr[1] == 'B') {
            black++;
        } else {
            white++;
        }

        while(true) {
            if(black <= B && white >= W) {
                max = Math.max(max, right - left + 1);
                right++;
            } else if(white < W) {
                right++;
            } else if(black > B && white >= W) {
                if(arr[left] == 'B') {
                    black--;
                } else {
                    white--;
                }
                left++;
                continue;
            }

            if(right >= N) {
                break;
            } else {
                if(arr[right] == 'B') {
                    black++;
                } else {
                    white++;
                }
            }
        }

        System.out.print(max);
    }
}
