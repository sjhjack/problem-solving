import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            boolean isEnd = true;

            if(N <= 2) {
                ans.append(2).append("\n");
                continue;
            }

            while(true) {
                isEnd = true;
                
                for(int i = 2; i <= (int)Math.sqrt(N); i++) {
                    if(N % i == 0) {
                        isEnd = false;
                        break;
                    }
                }

                if(isEnd) {
                    ans.append(N).append("\n");
                    break;
                }

                N++;
            }
        }

        System.out.print(ans);
    }
}