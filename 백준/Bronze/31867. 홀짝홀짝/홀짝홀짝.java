import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int odd = 0;
        int even = 0;

        for(int i = 0; i < N; i++) {
            int number = arr[i] - '0';

            if(number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int ans = 0;
        
        if(odd == even) {
            ans = -1;
        } else if(odd > even) {
            ans = 1;
        } else {
            ans = 0;
        }

        System.out.print(ans);
    }
}