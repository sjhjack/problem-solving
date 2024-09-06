import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int next = N;
        int ans = 0;

        do {
            ans++;
            int tmp = 0;

            if(next < 10) {
                tmp = next;
            } else {
                tmp = ((next / 10) + (next % 10)) % 10;
            }

            next = (next % 10) * 10 + tmp;
        } while(N != next);

        System.out.print(ans);
    }
}
