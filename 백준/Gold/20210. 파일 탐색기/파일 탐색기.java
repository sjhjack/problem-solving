import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
    static Map<Character, Integer> alphaMap;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() {
        alphaMap = new HashMap<>();

        for(int i = 0; i <= 'z'-'a'; i++) {
            alphaMap.put((char)('A' + i), i * 2);
            alphaMap.put((char)('a' + i), i * 2 + 1);
        }
    }

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        MyString[] arr = new MyString[N];

        for(int i = 0; i < N; i++) {
            arr[i] = new MyString(br.readLine().toCharArray());
        }

        Arrays.sort(arr);

        for(MyString myString : arr) {
            ans.append(myString.toString()).append("\n");
        }

        System.out.print(ans);
    }

    static class MyString implements Comparable<MyString> {
        char[] text;

        public MyString(char[] text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return new String(text);
        }

        @Override
        public int compareTo(MyString o) {
            int myIdx = 0;
            int otherIdx = 0;

            while(myIdx < text.length && otherIdx < o.text.length) {
                // 숫자 - 문자
                if(isNumber(text[myIdx]) && !isNumber(o.text[otherIdx])) {
                    return -1;
                } 
                // 문자 - 숫자
                else if(!isNumber(text[myIdx]) && isNumber(o.text[otherIdx])) {
                    return 1;
                } 
                // 숫자 - 숫자
                else if(isNumber(text[myIdx]) && isNumber(o.text[otherIdx])) {
                    int myZeroCnt = 0;
                    int otherZeroCnt = 0;

                    while(myIdx < text.length && text[myIdx] == '0') {
                        myZeroCnt++;
                        myIdx++;
                    }
                    
                    while(otherIdx < o.text.length && o.text[otherIdx] == '0') {
                        otherZeroCnt++;
                        otherIdx++;
                    }

                    StringBuilder myNumber = new StringBuilder();
                    while(myIdx < text.length && isNumber(text[myIdx])) {
                        myNumber.append(text[myIdx++]);
                    }

                    StringBuilder otherNumber = new StringBuilder();
                    while(otherIdx < o.text.length && isNumber(o.text[otherIdx])) {
                        otherNumber.append(o.text[otherIdx++]);
                    }

                    BigInteger myBigNumber = new BigInteger(myNumber.length() == 0 ? "0" : myNumber.toString());
                    BigInteger otherBigNumber = new BigInteger(otherNumber.length() == 0 ? "0" : otherNumber.toString());
                    int compare = myBigNumber.compareTo(otherBigNumber);

                    if(compare != 0) {
                        return compare;
                    }

                    if(myZeroCnt != otherZeroCnt) {
                        return myZeroCnt - otherZeroCnt;
                    }
                }
                // 문자 - 문자
                else {
                    if(text[myIdx] != o.text[otherIdx]) {                        
                        return alphaMap.get(text[myIdx]) - alphaMap.get(o.text[otherIdx]);
                    }
                    myIdx++;
                    otherIdx++;
                }
            }

            // 남은 문자열 길이 비교
            if(myIdx == text.length && otherIdx != o.text.length) {
                return -1;
            } else if(myIdx != text.length && otherIdx == o.text.length) {
                return 1;
            }
            
            return 0;
        }

        private boolean isNumber(char c) {
            return '0' <= c && c <= '9';
        }
    }
}
