import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] arr = new Stack[N + 1];
        
        for(int i = 1; i <= N; i++) {
            arr[i] = new Stack<>();
        }

        int ans = 0;
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int melody = Integer.parseInt(st.nextToken());
            int prat = Integer.parseInt(st.nextToken());

            while(!arr[melody].isEmpty() && arr[melody].peek() > prat) {
                arr[melody].pop();
                ans++;
            }

            if(arr[melody].isEmpty() || arr[melody].peek() < prat) {
                arr[melody].add(prat);
                ans++;
            }
        }

        System.out.print(ans);
    }
}