import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] arr;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        // index 저장
        stack.add(0);

        for(int i = 1; i < N; i++){
            // 현재값이 더 큰 경우
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }

            stack.add(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
    }

    private static void print() {
        StringBuilder ans = new StringBuilder();

        for(int num : arr){
            ans.append(num).append(" ");
        }

        System.out.print(ans);
    }
}
