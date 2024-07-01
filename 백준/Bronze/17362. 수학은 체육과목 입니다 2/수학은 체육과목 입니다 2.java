import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        
        if(N % 8 == 1) {
            ans = 1;
        } else if(N % 8 == 2 || N % 8 == 0) {
            ans = 2;
        } else if(N % 8 == 3 || N % 8 == 7) {
            ans = 3;
        } else if(N % 8 == 4 || N % 8 == 6) {
            ans = 4;
        } else if(N % 8 == 5) {
            ans = 5;
        }
        
        System.out.print(ans);
    }
}