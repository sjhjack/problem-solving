import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int SIZE = 5;
    
    static Map<Integer, Pos> map;
    static int[] rowCnt;
    static int[] colCnt;
    static int crossEqualCnt;
    static int crossNotEqualCnt;
    static int bingo;

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void markNumber() {
            markRow();
            markCol();
            markCrossEqual();
            markCrossNotEqual();
        }

        private void markRow() {
            rowCnt[row]++;
            if(rowCnt[row] == SIZE) {
                bingo++;
            }
        }

        private void markCol() {
            colCnt[col]++;
            if(colCnt[col] == SIZE) {
                bingo++;
            }
        }

        private void markCrossEqual() {
            if(row == col) {
                crossEqualCnt++;
                if(crossEqualCnt == SIZE) {
                    bingo++;
                }
            }
        }

        private void markCrossNotEqual() {
            if(row == 4 - col) {
                crossNotEqualCnt++;
                if(crossNotEqualCnt == SIZE) {
                    bingo++;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        map = new HashMap<>();
        rowCnt = new int[SIZE];
        colCnt = new int[SIZE];

        for(int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < SIZE; j++) {
                int number = Integer.parseInt(st.nextToken());
                map.put(number, new Pos(i, j));
            }
        }
    }

    static void solve() throws IOException {
        int ans = 0;

        for(int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < SIZE; j++) {
                int number = Integer.parseInt(st.nextToken());
                Pos cur = map.get(number);
                
                ans++;
                cur.markNumber();

                if(bingo >= 3) {
                    System.out.print(ans);
                    return;
                }
            }
        }
    }
}
