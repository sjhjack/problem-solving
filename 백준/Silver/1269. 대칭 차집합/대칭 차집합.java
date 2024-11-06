import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> setA2 = new HashSet<>();
        Set<Integer> setB2 = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            setA.add(number);
            setA2.add(number);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            setB.add(number);
            setB2.add(number);
        }

        for(int number : setA) {
            if(setB2.contains(number)) {
                setB2.remove(number);
            }
        }

        for(int number : setB) {
            if(setA2.contains(number)) {
                setA2.remove(number);
            }
        }

        System.out.print(setA2.size() + setB2.size());
    }
}