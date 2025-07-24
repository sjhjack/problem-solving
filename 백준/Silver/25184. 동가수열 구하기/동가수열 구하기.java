import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int left = N / 2;
        int right = left * 2;

        for(int i = 0; i < N / 2; i++) {
            ans.append(left--).append(" ").append(right--).append(" ");
        }

        if(N % 2 > 0) {
            ans.append(N);
        }

        System.out.print(ans);
    }
}
