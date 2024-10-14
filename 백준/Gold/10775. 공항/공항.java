import java.io.*;

class Main {
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];

        for(int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int ans = 0;
        
        for(int i = 0; i < P; i++) {
            int flight = Integer.parseInt(br.readLine());
            int emptyGate = find(flight);

            if(emptyGate == 0) {
                break;
            }
            
            union(emptyGate, emptyGate - 1);
            ans++;
        }

        System.out.print(ans);
    }

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[x] = y;
        }
    }
}