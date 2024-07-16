import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(a == b && b == c) {
            System.out.print(10000 + 1000 * a);
        } else if (a == b && b != c) {
            System.out.print(1000 + a * 100);
        } else if (a != b && b == c) {
            System.out.print(1000 + b * 100);
        } else if (a == c && b != c) {
            System.out.print(1000 + a * 100);
        } else {
            System.out.print(Math.max(Math.max(a, b), c) * 100);
        }
    }
}