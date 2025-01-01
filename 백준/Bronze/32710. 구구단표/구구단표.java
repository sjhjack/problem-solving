import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean canFind = false;

        for(int i = 1; i <= 9; i++) {
            if(N % i == 0 && N / i <= 9) {
                canFind = true;
                break;
            }
        }

        System.out.print(canFind ? 1 : 0);
    }
}