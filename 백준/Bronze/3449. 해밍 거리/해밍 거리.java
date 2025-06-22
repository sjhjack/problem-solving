import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();
            int count = 0;

            for(int i = 0; i < a.length; i++) {
                if(a[i] != b[i]) {
                    count++;
                }
            }

            ans.append("Hamming distance is ").append(count).append(".\n");
        }

        System.out.print(ans);
    }
}
