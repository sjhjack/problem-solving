import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int add = Integer.parseInt(br.readLine());
        int time = A * 3600 + B * 60 + C + add;

        int second = time % 60;
        time -= second;

        int minute = time % 3600 / 60;
        time -= time % 3600;

        int hour = time / 3600 % 24;

        System.out.print(hour + " " + minute + " " + second);
    }
}