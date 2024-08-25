import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String s;

        while((s = br.readLine()) != null) {
            ans.append(s).append("\n");
        }
        
        System.out.print(ans);
    }
}