import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[10][21];

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            int num = 0;

            for(int j = 1; j < Math.max(2, tmp.length); j++) {
                num = num * 10 + (tmp[j] - '0');
            }

            arr[tmp[0] - 'A'][num] = true;
        }

        for(int i = 0; i < 10; i++) {
            for(int j = 1; j <= 20; j++) {
                if(arr[i][j]) {
                    ans.append("o");
                } else {
                    ans.append(".");
                }
            }
            ans.append("\n");
        }

        System.out.print(ans);
    }
}