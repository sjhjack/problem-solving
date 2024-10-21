import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Queue<Player> queue;

    static class Player {
        int num;
        long life;
        long power;

        public Player(int num, long life, long power) {
            this.num = num;
            this.life = life;
            this.power = power;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queue = new ArrayDeque<>();

        long[] damage = new long[N + 1];
        long[] health = new long[N + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N; i++) {
            damage[i] = Long.parseLong(st1.nextToken());
            health[i] = Long.parseLong(st2.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            queue.add(new Player(i, health[i], damage[i]));
        }
    }

    static void solve() {
        long totDamage = 0;
        int round = 0;

        while(queue.size() > 1) {
            for(int i = queue.size(); i > 0; i--) {
                Player cur = queue.poll();
                
                if(cur.life - (totDamage - cur.power * round) > 0) {
                    queue.add(cur);
                    totDamage += cur.power;
                }
            }
            
            round++;
        }

        System.out.print(queue.poll().num);
    }
}
