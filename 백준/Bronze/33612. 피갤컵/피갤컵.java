import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int year = 2024 + (1 + 7*N) / 13;
        int month = 7 * N % 12 + 1;

        System.out.print(year + " " + month);
    }
}