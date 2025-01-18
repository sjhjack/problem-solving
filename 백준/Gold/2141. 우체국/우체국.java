import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Village[] arr;
    static long mid;

    static class Village implements Comparable<Village> {
        int position;
        int count;

        public Village(int position, int count) {
            this.position = position;
            this.count = count;
        }

        @Override
        public int compareTo(Village o) {
            return position - o.position;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Village[N];
        
        long sum = 0;        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            arr[i] = new Village(position, count);            
            sum += count;
        }

        mid = (sum + 1) / 2;
    }

    static void solve() {
        long sum = 0;

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            sum += arr[i].count;

            if(sum >= mid) {
                System.out.print(arr[i].position);
                break;
            }
        }        
    }
}
