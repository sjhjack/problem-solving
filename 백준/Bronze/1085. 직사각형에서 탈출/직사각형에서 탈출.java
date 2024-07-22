import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] arr = new int[4];
        arr[0] = x;
        arr[1] = w - x;
        arr[2] = y;
        arr[3] = h - y;

        Arrays.sort(arr);

        System.out.print(arr[0]);
    }
}