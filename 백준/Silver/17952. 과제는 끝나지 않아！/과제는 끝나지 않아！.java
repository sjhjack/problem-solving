import java.io.*;
import java.util.*;

class Main {
    static class Work {
        int score;
        int time;
        int elapsed;

        public Work(int score, int time) {
            this.score = score;
            this.time = time;
            this.elapsed = 1;
        }

        private boolean isOver() {
            return this.time == this.elapsed;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Work> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int score = 0;
        Work work = null;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            if(s.equals("0")) {
                if(work == null) {
                    if(stack.isEmpty()) {
                        continue;
                    }

                    // 이전 과제 할당
                    work = stack.pop();
                }
                
                work.elapsed++;
            } else {
                StringTokenizer st = new StringTokenizer(s);
                int command = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                // 이전 과제 저장
                if(work != null) {
                    stack.add(work);
                }

                // 새로운 과제 시작
                work = new Work(A, T);
            }

            // 현재 과제 끝
            if(work.isOver()) {
                score += work.score;
                work = null;
            }
        }

        System.out.print(score);
    }
}
