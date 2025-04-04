import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());

        if(T <= 30) {
            System.out.print(A);
        } else {
            T -= 30;

            int money = A + T / B * C + (T % B > 0 ? C : 0);
            System.out.print(money);
        }
    }
}