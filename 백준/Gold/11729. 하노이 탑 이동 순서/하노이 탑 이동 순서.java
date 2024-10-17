import java.io.*;
import java.util.*;

class Main {
    static StringBuilder ans = new StringBuilder();
    static int count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        movePlate(N, 1, 2, 3);
        
        System.out.println(count);
        System.out.print(ans);
    }

    static void movePlate(int N, int from, int mid, int to) {
        if(N == 1) {
            count++;
            print(from, to);
            
            return;
        }

        movePlate(N-1, from, to, mid);   // N-1개 중간으로 이동

        count++;
        print(from, to);                 // 제일 큰 원판 목적지로 이동

        movePlate(N-1, mid, from, to);   // N-1개 목적지로 이동
    }

    static void print(int from, int to) {
        ans.append(from).append(" ").append(to).append("\n");
    }
}
