import java.io.*;

class Main {
    static int count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            count = 0;
            int result = isPalindrome(br.readLine());

            ans.append(result).append(" ").append(count).append("\n");
        }

        System.out.print(ans);
    }

    static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
}