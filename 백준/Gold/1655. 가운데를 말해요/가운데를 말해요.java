import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        PriorityQueue<Integer> lowPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> highPQ = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        int mid = Integer.parseInt(br.readLine());
        ans.append(mid).append("\n");

        for(int i = 2; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num <= mid) {
                lowPQ.add(num);
            } else {
                highPQ.add(num);
            }

            if(i % 2 == 1) {
                while(!highPQ.isEmpty() && highPQ.size() > lowPQ.size()) {
                    lowPQ.add(mid);
                    mid = highPQ.poll();
                }

                while(!lowPQ.isEmpty() && lowPQ.size() > highPQ.size()) {
                    highPQ.add(mid);
                    mid = lowPQ.poll();
                }

                ans.append(mid).append("\n");
            } else {
                if(highPQ.size() == lowPQ.size() + 1) {
                    ans.append(mid).append("\n");
                } else if(highPQ.size() + 1 == lowPQ.size()) {
                    highPQ.add(mid);
                    mid = lowPQ.poll();
                    ans.append(mid).append("\n");
                }
            }
        }

        System.out.print(ans);
    }
}
