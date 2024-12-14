import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.print(1);
            return;
        }

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int sameScoreIndex = -1;
        
        while(index < N && index < P && arr[index] >= score) {
            if(arr[index] == score && sameScoreIndex < 0) {
                sameScoreIndex = index;
            }
            
            index++;
        }

        if(index >= P) {
            System.out.print(-1);
        } else {
            if(sameScoreIndex < 0) {
                System.out.print(index + 1);
            } else {
                System.out.print(sameScoreIndex + 1);
            }
        }
    }
}
