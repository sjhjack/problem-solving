import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int group = 1;

        while(true) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0) {
                break;
            }

            String[] name = new String[N];
            char[][] arr = new char[N][N - 1];
            boolean nobodyFlag = true;

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                name[i] = st.nextToken();

                for(int j = 0; j < N - 1; j++) {
                    arr[i][j] = st.nextToken().charAt(0);
                }
            }

            ans.append("Group ").append(group++).append("\n");

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N - 1; j++) {
                    if(arr[i][j] == 'N') {
                        nobodyFlag = false;
                        ans.append(name[(i + 1 + N-2-j) % N]).append(" was nasty about ").append(name[i]).append("\n");
                    }
                }
            }

            if(nobodyFlag) {
                ans.append("Nobody was nasty\n");
            }

            ans.append("\n");
        }

        System.out.print(ans);
    }
}
