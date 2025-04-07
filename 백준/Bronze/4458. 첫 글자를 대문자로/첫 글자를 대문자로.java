import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();

            if('a' <= tmp[0] && tmp[0] <= 'z') {
                tmp[0] ^= 32;
            }

            ans.append(new String(tmp)).append("\n");
        }

        System.out.print(ans);
    }
}