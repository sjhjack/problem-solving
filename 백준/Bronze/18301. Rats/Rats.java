import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        int N12 = Integer.parseInt(st.nextToken());

        System.out.print((int)((N1 + 1) * (N2 + 1) / (N12 + 1) - 1));
    }
}