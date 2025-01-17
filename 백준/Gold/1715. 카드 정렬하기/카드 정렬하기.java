import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Set<Integer> set;
    static PriorityQueue<Card> pq;

    static class Card implements Comparable<Card> {
        int index;
        int size;

        public Card(int index, int size) {
            this.index = index;
            this.size = size;
        }

        @Override
        public int compareTo(Card o) {
            return size - o.size;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            int size = Integer.parseInt(br.readLine());
            
            pq.add(new Card(i, size));
            set.add(i);
        }
    }

    static void solve() {
        int ans = 0;
        
        while(set.size() > 1 && pq.size() >= 2) {
            Card card1 = pq.poll();
            Card card2 = pq.poll();

            int index = Math.min(card1.index, card2.index);
            int size = card1.size + card2.size;
            
            pq.add(new Card(index, size));
            set.remove(Math.max(card1.index, card2.index));
            ans += size;
        }

        System.out.print(ans);
    }
}
