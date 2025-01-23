import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        char[] arr = br.readLine().toCharArray();
        char[] key = br.readLine().toCharArray();

        int keyIdx = 0;

        for(int i = 0; i < arr.length; i++, keyIdx++) {
            keyIdx = keyIdx % key.length;

            if(arr[i] == ' ') {
                ans.append(" ");
                continue;
            }

            int gap = key[keyIdx] - 'a' + 1;
            int next = (int)arr[i] - gap;

            if(next < (int)'a') {
                next += 'z' - 'a' + 1;
            }

            ans.append((char)next);
        }

        System.out.print(ans);
    }
}
