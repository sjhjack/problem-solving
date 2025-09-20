import java.io.*;
import java.util.*;

class Main {
    static int A, B, C;
    
    static class Water {
        int a;
        int b;
        int c;

        public Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        Queue<Water> queue = new ArrayDeque<>();
        boolean[][][] isVisited = new boolean[201][201][201];
        boolean[] isAdded = new boolean[C + 1];
        List<Integer> list = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        queue.add(new Water(0, 0, C));
        isVisited[0][0][C] = true;

        while(!queue.isEmpty()) {
            Water cur = queue.poll();

            if(cur.a == 0 && !isAdded[cur.c]) {
                isAdded[cur.c] = true;
                list.add(cur.c);
            }

            int tmpA = 0;
            int tmpB = 0;
            int tmpC = 0;

            // A -> B
            if(cur.a + cur.b <= B) {
                tmpB = cur.a + cur.b;

                if(!isVisited[0][tmpB][cur.c]) {
                    isVisited[0][tmpB][cur.c] = true;
                    queue.add(new Water(0, tmpB, cur.c));
                }
            } else {
                tmpA = cur.a + cur.b - B;

                if(!isVisited[tmpA][B][cur.c]) {
                    isVisited[tmpA][B][cur.c] = true;
                    queue.add(new Water(tmpA, B, cur.c));
                }
            }

            // B -> A
            if(cur.a + cur.b <= A) {
                tmpA = cur.a + cur.b;

                if(!isVisited[tmpA][0][cur.c]) {
                    isVisited[tmpA][0][cur.c] = true;
                    queue.add(new Water(tmpA, 0, cur.c));
                }
            } else {
                tmpB = cur.a + cur.b - A;

                if(!isVisited[A][tmpB][cur.c]) {
                    isVisited[A][tmpB][cur.c] = true;
                    queue.add(new Water(A, tmpB, cur.c));
                }
            }

            // A -> C
            if(cur.a + cur.c <= C) {
                tmpC = cur.a + cur.c;

                if(!isVisited[0][cur.b][tmpC]) {
                    isVisited[0][cur.b][tmpC] = true;
                    queue.add(new Water(0, cur.b, tmpC));
                }
            } else {
                tmpA = cur.a + cur.c - C;

                if(!isVisited[tmpA][cur.b][C]) {
                    isVisited[tmpA][cur.b][C] = true;
                    queue.add(new Water(tmpA, cur.b, C));
                }
            }

            // C -> A
            if(cur.a + cur.c <= A) {
                tmpA = cur.a + cur.c;

                if(!isVisited[tmpA][cur.b][0]) {
                    isVisited[tmpA][cur.b][0] = true;
                    queue.add(new Water(tmpA, cur.b, 0));
                }
            } else {
                tmpC = cur.a + cur.c - A;

                if(!isVisited[A][cur.b][tmpC]) {
                    isVisited[A][cur.b][tmpC] = true;
                    queue.add(new Water(A, cur.b, tmpC));
                }
            }

            // B -> C
            if(cur.b + cur.c <= C) {
                tmpC = cur.b + cur.c;

                if(!isVisited[cur.a][0][tmpC]) {
                    isVisited[cur.a][0][tmpC] = true;
                    queue.add(new Water(cur.a, 0, tmpC));
                }
            } else {
                tmpB = cur.b + cur.c - C;

                if(!isVisited[cur.a][tmpB][C]) {
                    isVisited[cur.a][tmpB][C] = true;
                    queue.add(new Water(cur.a, tmpB, C));
                }
            }

            // C -> B
            if(cur.b + cur.c <= B) {
                tmpB = cur.b + cur.c;

                if(!isVisited[cur.a][tmpB][0]) {
                    isVisited[cur.a][tmpB][0] = true;
                    queue.add(new Water(cur.a, tmpB, 0));
                }
            } else {
                tmpC = cur.b + cur.c - B;

                if(!isVisited[cur.a][B][tmpC]) {
                    isVisited[cur.a][B][tmpC] = true;
                    queue.add(new Water(cur.a, B, tmpC));
                }
            }
        }

        Collections.sort(list);

        for(int c : list) {
            ans.append(c).append(" ");
        }

        System.out.print(ans);
    }
}
