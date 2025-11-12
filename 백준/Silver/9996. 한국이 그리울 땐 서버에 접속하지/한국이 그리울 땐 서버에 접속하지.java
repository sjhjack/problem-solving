import java.io.*;
import java.util.regex.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("\\*");
        String pattern = "^"+arr[0]+"[a-z]*"+arr[1]+"$";
        int length = arr[0].length() + arr[1].length();

        for(int i = 0; i < N; i++) {
            String title = br.readLine();
            ans.append(title.length() >= length && Pattern.matches(pattern, title) ? "DA" : "NE").append("\n");
        }

        System.out.print(ans);
    }
}