import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count[] = new int[10];
        char[] arr = br.readLine().toCharArray();

        for(int i = 0; i < arr.length; i++) {
            count[arr[i] - '0']++;
        }

        int max = 0;
        for(int i = 0; i < 10; i++) {
            if(i == 6 || i == 9) {
                max = Math.max(max, ((count[6]+count[9]) / 2) + (count[6]+count[9]) % 2);
            } else {
                max = Math.max(max, count[i]);
            }
        }

        System.out.print(max);
    }
}