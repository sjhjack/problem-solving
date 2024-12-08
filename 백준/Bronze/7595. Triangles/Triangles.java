import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while(true) {
            int N = Integer.parseInt(br.readLine());
            
            if(N == 0) {
                break;
            }

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= i; j++) {
                    ans.append("*");
                }
                ans.append("\n");
            }
        }

        System.out.print(ans);
    }
}