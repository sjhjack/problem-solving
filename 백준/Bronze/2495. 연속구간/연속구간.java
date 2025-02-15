import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        for(int t = 0; t < 3; t++) {
            char[] arr = br.readLine().toCharArray();
            int max = 1;
            int count = 0;
            char now = 'x';

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == now) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                    now = arr[i];
                }
            }

            max = Math.max(max, count);

            ans.append(max).append("\n");
        }

        System.out.print(ans);
    }
}