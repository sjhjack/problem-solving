import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int N = text.length();

        for(int i = 0; i < N; i++) {
            if(i + 1 < N && text.startsWith("pi", i)) {
                i++;
            } else if(i + 1 < N && text.startsWith("ka", i)) {
                i++;
            } else if(i + 2 < N && text.startsWith("chu", i)) {
                i+=2;
            } else {
                System.out.print("NO");
                return;
            }
        }
        
        System.out.print("YES");
    }
}