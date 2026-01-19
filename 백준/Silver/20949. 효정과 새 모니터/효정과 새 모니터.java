import java.io.*;
import java.util.*;

class Main {
    static class Ppi implements Comparable<Ppi> {
        int index;
        double ppi;

        public Ppi(int index, int W, int H) {
            this.index = index;
            this.ppi = Math.sqrt(W*W + H*H) / 77;
        }

        @Override
        public int compareTo(Ppi o) {
            if(ppi == o.ppi) {
                return index - o.index;
            }
            return Double.compare(o.ppi, this.ppi);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Ppi[] arr = new Ppi[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[i] = new Ppi(i + 1, W, H);
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            ans.append(arr[i].index).append("\n");
        }

        System.out.print(ans);
    }
}