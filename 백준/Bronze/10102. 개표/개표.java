import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int A = 0;
        int B = 0;

        for(int i = 0; i < N; i++) {
            if(arr[i] == 'A') {
                A++;
            } else {
                B++;
            }
        }

        if(A > B) System.out.print("A");
        else if(A < B) System.out.print("B");
        else System.out.print("Tie");
    }
}