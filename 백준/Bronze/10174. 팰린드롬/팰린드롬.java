import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int n = 0; n < N; n++) {
            char[] arr = br.readLine().toLowerCase().toCharArray();
            boolean isPal = true;

            for(int i = 0; i < arr.length / 2; i++) {
                if(arr[i] != arr[arr.length - 1 - i]) {
                    isPal = false;
                    break;
                }
            }

            ans.append(isPal ? "Yes\n" : "No\n");
        }

        System.out.print(ans);
    }
}
