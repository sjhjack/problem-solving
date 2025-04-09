import java.io.*;

class Main {
    static int N, M;
    static char[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
    }

    static void solve() {
        int ans = 0;
        int count = 0;

        for(int i = 0; i < M - 2; i++) {
            if(arr[i] == 'I' && arr[i + 1] == 'O' && arr[i + 2] == 'I') {
                count++;

                if(count == N) {
                    ans++;
                    count--;
                }
                
                i++;    // 다음 'IOI' 자리로 이동하기 위해 'O'는 더 건너뜀
            } else {
                count = 0;
            }
        }

        System.out.print(ans);
    }
}
