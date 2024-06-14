import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N < 100) {
            System.out.print((N / 10) + (N % 10));
        } else if(101 <= N && N <= 109) {
            System.out.print(10 + (N % 10));
        } else if(110 <= N && N <= 910) {
            System.out.print((N / 100) + 10);
        } else if(N == 1010) {
            System.out.print(20);
        }
    }
}