import java.io.*;

class Main {
    static String S;
    static boolean canMake;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        String T = br.readLine();

        solve(T);

        System.out.print(canMake ? 1 : 0);
    }

    static void solve(String cur) {
        if(canMake) {
            return;
        }
        
        if(cur.length() == S.length()) {
            if(cur.equals(S)) {
                canMake = true;
            }
            return;
        }
        
        if(cur.endsWith("A")) {
            solve(cur.substring(0, cur.length()-1));
        }
        if(cur.startsWith("B")) {
            String reverse = new StringBuilder(cur.substring(1)).reverse().toString();
            solve(reverse);
        }
    }
}
