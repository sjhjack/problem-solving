import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static char[] command;
    static String[] numbers;
    static int N;
    static int start, end, cnt;
    static boolean isReverse;

    public static void main(String[] args) throws IOException {
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 0; t < test_case; t++) {
            input();
            solve();
        }

        System.out.print(answer);
    }

    static void input() throws IOException {
        command = br.readLine().toCharArray();
        N = Integer.parseInt(br.readLine());

        numbers = new String[N];

        String s = br.readLine();
        s = s.substring(1, s.length() - 1);
        numbers = s.split(",");
    }

    static void solve(){
        StringBuilder ans = new StringBuilder();

        start = 0;
        end = numbers.length - 1;
        cnt = N;
        isReverse = false;

        for(char cmd : command){
            if(cmd == 'R'){
                swap();
            } else {
                if(cnt == 0){
                    ans = new StringBuilder("error\n");
                    break;
                } else {
                    if(start <= end) start++;
                    else start--;

                    cnt--;
                }
            }
        }

        if(ans.length() == 0) {
            ans.append("[");
            if(start == end){
                ans.append(numbers[start]).append("]");
            } else{
                if(!isReverse){
                    for(int i = start; i < end; i++){
                        ans.append(numbers[i]).append(",");
                    }
                    if(cnt > 0) ans.append(numbers[end]);
                    ans.append("]");
                } else{
                    for(int i = start; i > end; i--){
                        ans.append(numbers[i]).append(",");
                    }
                    if(cnt > 0) ans.append(numbers[end]);
                    ans.append("]");
                }
            }

            ans.append("\n");
        }

        answer.append(ans);
    }

    static void swap(){
        int tmp = start;
        start = end;
        end = tmp;

        isReverse = !isReverse;
    }
}
