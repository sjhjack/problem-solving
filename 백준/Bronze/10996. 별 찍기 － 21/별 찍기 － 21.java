import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N * 2; i++) {
            for(int j = 0; j < N; j++) {
                if(i % 2 == j % 2) {
                    ans.append("*");
                } else {
                    ans.append(" ");
                }
            }
            
            ans.append("\n");
        }

        System.out.print(ans);
    }
}
