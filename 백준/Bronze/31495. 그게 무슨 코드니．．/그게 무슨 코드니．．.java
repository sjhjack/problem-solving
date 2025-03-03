import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        char[] arr = br.readLine().toCharArray();

        if(arr.length >= 2 && arr[0] == '"' && arr[arr.length - 1] == '"') {
            boolean isBlank = true;
            
            for(int i = 1; i < arr.length - 1; i++) {
                if(arr[i] != ' ') {
                    isBlank = false;
                }
                ans.append(arr[i]);
            }
            
            System.out.print(isBlank ? "CE" : ans);
        } else {
            System.out.print("CE");
        }        
    }
}