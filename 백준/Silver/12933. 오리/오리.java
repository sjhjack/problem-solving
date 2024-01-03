import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int qCnt = 0;
        int uCnt = 0;
        int aCnt = 0;
        int cCnt = 0;
        int kCnt = 0;
        int duck = 0;
        boolean flag = false;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'q'){
                if(i == 0){
                    duck++;
                } else {
                    if(kCnt == 0){
                        duck++;
                    } else {
                        kCnt--;
                    }
                }
                qCnt++;
            } else if(arr[i] == 'u'){
                if(qCnt == 0){
                    flag = true;
                    break;
                }
                qCnt--;
                uCnt++;
            } else if(arr[i] == 'a'){
                if(uCnt == 0){
                    flag = true;
                    break;
                }
                uCnt--;
                aCnt++;
            } else if(arr[i] == 'c'){
                if(aCnt == 0){
                    flag = true;
                    break;
                }
                aCnt--;
                cCnt++;
            } else {
                if(cCnt == 0){
                    flag = true;
                    break;
                }
                cCnt--;
                kCnt++;
            }
        }

        if(flag || (qCnt | uCnt | aCnt | cCnt) > 0) System.out.print(-1);
        else System.out.print(duck);
    }
}
