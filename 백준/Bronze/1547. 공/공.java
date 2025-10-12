import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] cup = new boolean[4];
        int M = Integer.parseInt(br.readLine());

        cup[1] = true;

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cup[a] || cup[b]) {
                cup[a] = !cup[a];
                cup[b] = !cup[b];
            }
        }

        for(int i = 1; i <= 3; i++) {
            if(cup[i]) {
                System.out.print(i);
                break;
            }
        }
    }
}