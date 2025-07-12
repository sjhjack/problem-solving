import java.io.*;
import java.util.*;

class Main {
    static class Word implements Comparable<Word> {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            if(count == o.count) {
                if(o.word.length() == word.length()) {
                    return word.compareTo(o.word);
                }
                return o.word.length() - word.length();
            }
            return o.count - count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Word> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            if(s.length() < M) {
                continue;
            }

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Word(entry.getKey(), entry.getValue()));
        }

        while(!pq.isEmpty()) {
            ans.append(pq.poll().word).append("\n");
        }

        System.out.print(ans);
    }
}
