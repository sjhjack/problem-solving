import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        char[] arr = br.readLine().toCharArray();

        ans.append(arr).append("\n");
        
        for(int gap = 1; gap <= 25; gap++) {
            for(int i = 0; i < arr.length; i++) {
                int tmp = arr[i] - gap;
                ans.append(tmp < 'A' ? (char)(tmp + 26) : (char)tmp);
            }
            ans.append("\n");
        }

        System.out.print(ans);
    }
}