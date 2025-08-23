import java.io.*;
import java.util.*;

class Main {
    static class Word implements Comparable<Word> {
        String word;
        int score;

        public Word(String word) {
            this.word = word;
            this.score = calcScore();
        }

        private int calcScore() {
            boolean[] isBonus = new boolean[27];
            char[] arr = word.toCharArray();
            int sum = 0;

            for(int i = 0; i < arr.length; i++) {
                if(i > 0 && arr[i] == arr[i - 1]) {
                    isBonus[arr[i] - 'a' + 1] = true;
                }

                sum += arr[i] - 'a' + 1;
            }

            for(int i = 1; i <= 26; i++) {
                if(isBonus[i]) {
                    sum += i * 2;
                }
            }

            return sum;
        }

        @Override
        public int compareTo(Word o) {
            if(score == o.score) {
                return word.compareTo(o.word);
            }
            return o.score - score;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        PriorityQueue<Word> pq = new PriorityQueue<>();
        String word = "";

        while((word = br.readLine()) != null) {
            pq.add(new Word(word));
        }

        while(pq.size() > 1) {
            ans.append(pq.poll().word).append("\n");
        }

        ans.append(pq.poll().word);

        System.out.print(ans);
    }
}
