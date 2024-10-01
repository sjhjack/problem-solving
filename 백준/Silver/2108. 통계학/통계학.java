import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        ans.append(Math.round(sum / (double)N)).append("\n");
        ans.append(arr[N / 2]).append("\n");

        Queue<Integer> q = new ArrayDeque<>();
        q.add(arr[0]);
        int tmp = arr[0];
        int maxCnt = 0;
        int cnt = 1;
        
        for(int i = 1; i < N; i++) {
            if(arr[i] == tmp) {
                cnt++;
                continue;
            } else {
                if(cnt == maxCnt) {
                    q.add(tmp);
                } else if(cnt > maxCnt) {
                    maxCnt = cnt;
                    q = new ArrayDeque<>();
                    q.add(tmp);
                }

                tmp = arr[i];
                cnt = 1;
            }
        }

        if(cnt == maxCnt) {
            q.add(tmp);
        } else if(cnt > maxCnt) {
            maxCnt = cnt;
            q = new ArrayDeque<>();
            q.add(tmp);
        }

        if(q.size() > 1) {
            q.poll();
        }

        ans.append(q.poll()).append("\n");

        ans.append(Math.abs(arr[N-1] - arr[0]));

        System.out.print(ans);
    }
}
