import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] cranes;
    static List<Integer> boxes;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cranes = new int[N];
        boxes = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        Arrays.sort(cranes);
        boxes.sort(Collections.reverseOrder());

        if(cranes[N - 1] < boxes.get(0)) {
            System.out.print(-1);
            return;
        }

        int time = 0;
        while(!boxes.isEmpty()) {
            int crane = N - 1;
            int box = 0;

            while(crane >= 0) {
                if(box == boxes.size()) {
                    break;
                } else if(cranes[crane] >= boxes.get(box)) {
                    boxes.remove(box);
                    crane--;
                } else {
                    box++;
                }
            }

            time++;
        }

        System.out.print(time);
    }
}