import java.util.*;
import java.io.*;

class Main {

    static int N, P, E;
    static int[][] arr;
    static List<Integer> list = new ArrayList<>();
    static int leftover;
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        if(selectMember(0, 0, 0, 0)) {
            giveDuck(true);
        } else {
            giveDuck(false);
        }
    }

    static boolean selectMember(int idx, int min, int max, int cnt) {
        if(cnt == P && min <= E && E <= max) {
            leftover = E - min;
            return true;
        }
        
        if(idx >= N) {
            return false;
        }

        list.add(idx);
        
        if(selectMember(idx + 1, min + arr[idx][0], max + arr[idx][1], cnt + 1)) {
            return true;
        }

        list.remove(list.size() - 1);

        if(selectMember(idx + 1, min, max, cnt)) {
            return true;
        }

        return false;
    }

    static void giveDuck(boolean canGiveDucks) {
        if(canGiveDucks) {
            StringBuilder ans = new StringBuilder();
            int[] duckCnt = new int[N];

            for(int idx : list) {
                duckCnt[idx] = arr[idx][0];

                if(leftover > 0) {
                    int gap = arr[idx][1] - arr[idx][0];
                    int giveMoreDucks = Math.min(leftover, gap);
                    
                    duckCnt[idx] += giveMoreDucks;
                    leftover -= giveMoreDucks;
                }
            }

            for(int i = 0; i < N; i++) {
                ans.append(duckCnt[i]).append(" ");
            }
            
            System.out.print(ans);
        } else {
            System.out.print(-1);
        }
    }
}
