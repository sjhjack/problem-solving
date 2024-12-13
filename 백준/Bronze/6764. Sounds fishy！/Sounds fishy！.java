import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[4];
        
        for(int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(arr[0] < arr[1] && arr[1] < arr[2] && arr[2] < arr[3]) {
            System.out.print("Fish Rising");
        } else if(arr[0] > arr[1] && arr[1] > arr[2] && arr[2] > arr[3]) {
            System.out.print("Fish Diving");
        } else if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) {
            System.out.print("Fish At Constant Depth");
        } else {
            System.out.print("No Fish");
        }
    }
}