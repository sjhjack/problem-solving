import java.util.*;
import java.io.*;

class Main {
    private static final int ALL = Integer.parseInt("11111111111111111111", 2);
    private static final int EMPTY = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int S = 0;
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("all")) {
                S = ALL;
                continue;
            } else if(command.equals("empty")) {
                S = EMPTY;
                continue;
            }
            
            int x = Integer.parseInt(st.nextToken()) - 1;
            
            if(command.equals("add")) {
                S |= (1 << x);
            } else if(command.equals("remove")) {
                S &= ~(1 << x);
            } else if(command.equals("check")) {
                if((S & (1 << x)) > 0) {
                    ans.append("1\n");
                } else {
                    ans.append("0\n");
                }
            } else if(command.equals("toggle")) {
                if((S & (1 << x)) > 0) {
                    S &= ~(1 << x);
                } else {
                    S |= (1 << x);
                }
            }
        }

        System.out.print(ans);
    }
}