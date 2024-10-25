import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        boolean[] isUsed = new boolean[K + 1];
        int plugCnt = 0;
        int ans = 0;

        for(int i = 0; i < K; i++) {
            int now = arr[i];
            
            if(isUsed[now]) {
                // 이미 꽂혀있음
                continue;
            } else {
                // 새로 꽂아야됨
                if(plugCnt < N) {
                    // 콘센트 자리 있음
                    isUsed[now] = true;
                    plugCnt++;
                } else {
                    // 콘센트 자리 없음
                    Set<Integer> set = new HashSet<>();
                    int last = 0;

                    // 가장 나중에 재사용하는 플러그 제거
                    for(int j = i + 1; j < K; j++) {
                        if(isUsed[arr[j]] && !set.contains(arr[j])) {
                            set.add(arr[j]);
                            last = arr[j];
                        }
                    }

                    // 추가된다면 더 이상 사용하지 않는 플러그
                    for(int j = 0; j < i; j++) {
                        if(isUsed[arr[j]] && !set.contains(arr[j])) {
                            set.add(arr[j]);
                            last = arr[j];
                        }
                    }

                    isUsed[last] = false;
                    ans++;
                    isUsed[now] = true;
                }
            }
        }

        System.out.print(ans);
    }
}
