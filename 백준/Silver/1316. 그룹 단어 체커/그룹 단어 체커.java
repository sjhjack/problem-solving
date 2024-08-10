import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            boolean[] alpha = new boolean['z' - 'a' + 1];
            char[] arr = br.readLine().toCharArray();
            boolean isGroupWord = true;
            char now = arr[0];

            alpha[now - 'a'] = true;

            for(int i = 0; i < arr.length; i++) {
                if(now != arr[i]) {
                    now = arr[i];

                    // 이미 나온적 있는 알파벳인 경우
                    if(alpha[now - 'a']) {
                        isGroupWord = false;
                        break;
                    }
                    
                    alpha[now - 'a'] = true;
                }
            }

            if(isGroupWord) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}
