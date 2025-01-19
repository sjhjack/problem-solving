import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        for(int i = N - 5; i < N; i++) {
            ans.append(arr[i]);
        }

        System.out.print(ans);
    }
}