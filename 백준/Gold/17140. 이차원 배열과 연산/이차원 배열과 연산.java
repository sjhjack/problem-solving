import java.io.*;
import java.util.*;

class Main {
    static int R, C, K;
    static int[][] arr;
    static int maxR, maxC;

    static class Number implements Comparable<Number> {
        int number;
        int count;

        public Number(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Number o) {
            if(count == o.count) {
                return number - o.number;
            }

            return count - o.count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[101][101];

        for(int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        int count = 0;
        maxR = 3;
        maxC = 3;

        while(count < 100 && arr[R][C] != K) {
            count++;
            
            if(maxR >= maxC) {
                calcRow();
            } else {
                calcCol();
            }
        }

        System.out.print(arr[R][C] == K ? count : -1);
    }

    static void calcRow() {
        PriorityQueue<Number>[] pqList = new PriorityQueue[maxR + 1];
        int maxCol = maxC;

        for(int i = 1; i <= maxR; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            pqList[i] = new PriorityQueue<>();
            
            for(int j = 1; j <= maxC; j++) {
                if(arr[i][j] == 0) continue;

                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }

            for(int key : map.keySet()) {
                int value = map.get(key);
                pqList[i].add(new Number(key, value));
            }
            maxCol = Math.max(maxCol, pqList[i].size() * 2);
        }

        for(int i = 1; i <= maxR; i++) {
            int idx = 1;
            
            while(!pqList[i].isEmpty()) {
                Number cur = pqList[i].poll();
                arr[i][idx++] = cur.number;
                arr[i][idx++] = cur.count;
                
            }

            while(idx <= maxCol) {
                arr[i][idx++] = 0;
            }
        }

        maxC = maxCol;
    }

    static void calcCol() {
        PriorityQueue<Number>[] pqList = new PriorityQueue[maxC + 1];
        int maxRow = maxR;

        for(int i = 1; i <= maxC; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            pqList[i] = new PriorityQueue<>();
            
            for(int j = 1; j <= maxR; j++) {
                if(arr[j][i] == 0) continue;

                map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
            }

            for(int key : map.keySet()) {
                int value = map.get(key);
                pqList[i].add(new Number(key, value));
            }
            maxRow = Math.max(maxRow, pqList[i].size() * 2);
        }

        for(int i = 1; i <= maxC; i++) {
            int idx = 1;
            
            while(!pqList[i].isEmpty()) {
                Number cur = pqList[i].poll();
                arr[idx++][i] = cur.number;
                arr[idx++][i] = cur.count;
                
            }

            while(idx <= maxRow) {
                arr[idx++][i] = 0;
            }
        }

        maxR = maxRow;
    }
}
