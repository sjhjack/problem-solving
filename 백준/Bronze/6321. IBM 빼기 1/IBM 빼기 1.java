import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            ans.append("String #").append(i).append("\n");
            
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if(c == 'Z') {
                    ans.append('A');
                } else {
                    ans.append((char)(c + 1));
                }
            }

            ans.append("\n\n");
        }
        
        System.out.print(ans);
    }
}