import java.io.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int N = 123_456;
    static boolean[] isNotPrime;
    
    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        
        init();

        while(true) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                break;
            }

            ans.append(getCnt(num)).append("\n");
        }

        System.out.print(ans);
    }

    static void init() {
        int max = 2*N + 1;
        isNotPrime = new boolean[max];

        for(int i = 2; i <= Math.sqrt(max); i++) {
            for(int j = i + i; j <= max; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

    static int getCnt(int num) {
        int cnt = 0;
        
        for(int i = num + 1; i <= num * 2; i++) {
            if(!isNotPrime[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}
