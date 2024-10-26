import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int target;
    static int[] parent;
    static List<Integer>[] childList;
    static boolean[] isDeleted;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        childList = new List[N];
        isDeleted = new boolean[N];

        for(int i = 0; i < N; i++) {
            childList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            parent[i] = num;

            if(num < 0) continue;
            childList[num].add(i);
        }

        target = Integer.parseInt(br.readLine());
    }

    static void solve() {
        if(parent[target] >= 0) {
            childList[parent[target]].remove(Integer.valueOf(target));
        }

        removeNode(target);
    }

    static void removeNode(int num) {
        isDeleted[num] = true;
        
        for(int i = childList[num].size()-1; i >= 0; i--) {
            int child = childList[num].get(i);
            
            childList[num].remove(i);            
            removeNode(child);
        }
    }

    static void print() {
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            if(!isDeleted[i] && childList[i].size() == 0) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
