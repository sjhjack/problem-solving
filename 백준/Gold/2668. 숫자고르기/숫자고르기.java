import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static boolean[] isVisited;
    static List<Integer> list;
    
    public static void main(String[] args) throws IOException {
        init();

        for(int i = 1; i <= N; i++) {
            isVisited[i] = true;
            findCycle(arr[i], i);
            isVisited[i] = false;
        }

        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        isVisited = new boolean[N + 1];
        list = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void findCycle(int cur, int target) {
        // 처음 방문
        if(!isVisited[cur]) {
            isVisited[cur] = true;
            findCycle(arr[cur], target);
            isVisited[cur] = false;
        }

        // 방문했던 대상이면 사이클 확인
        if(cur == target) {
            list.add(target);
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();

        ans.append(list.size()).append("\n");

        for(int i : list) {
            ans.append(i).append("\n");
        }

        System.out.print(ans);
    }
}
