import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        char[][] arr = new char[5][15];
        int max = 0;

        for(int i = 0; i < 5; i++) {
            char[] tmp = br.readLine().toCharArray();
            max = Math.max(max, tmp.length);
            
            for(int j = 0; j < tmp.length; j++) {
                arr[i][j] = tmp[j];
            }
        }

        for(int i = 0; i < max; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[j][i] == '\0') continue;
                ans.append(arr[j][i]);
            }
        }

        System.out.print(ans);
    }
}