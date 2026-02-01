import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int[] cmd = new int[N];
        int card = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N - 1; i >= 0; i--) {
            if(cmd[i] == 1) {
                dq.addFirst(card);
            } else if(cmd[i] == 2) {
                int tmp = dq.pollFirst();
                
                dq.addFirst(card);
                dq.addFirst(tmp);
            } else if(cmd[i] == 3) {
                dq.addLast(card);
            }

            card++;
        }

        while(!dq.isEmpty()) {
            ans.append(dq.pollFirst()).append(" ");
        }

        System.out.print(ans);
    }
}