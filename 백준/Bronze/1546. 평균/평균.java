import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(arr);
        
        double max = arr[N - 1];
        double sum = 0;

        for(int i = 0; i < N; i++) {
            sum += arr[i] / max * 100;
        }

        System.out.print(sum / N);
    }
}