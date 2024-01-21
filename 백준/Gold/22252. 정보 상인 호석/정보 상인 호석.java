/**
 * 메모리 : 138904 KB
 * 시간 : 1384 ms
 * 
 * # 접근 : 고릴라 이름이 String이므로 HashMap의 key로 사용
 *         정보 가치가 높은 순서로 구매하므로 우선순위큐 사용
 *         
 *         1. 각 고릴라가 저장되는 인덱스를 HashMap의 value값으로 저장
 *         2. 해당 인덱스 위치의 List에 고릴라가 갖고 있는 정보의 가치를 우선순위큐로 저장
 *         3. poll()을 활용해서 한번 거래한 정보 파기
 *         4. 정답의 범위가 int범위를 넘으므로 long으로 선언 
 *         -> Solved !!
 *         
 *         ++ HashMap<String, PriorityQueue<Integer>>로 사옹했으면 따로 List를 만들고 index를 신경쓰지 않아도 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
    static int Q;
    static long sum;													// 범위를 항상 조심하자
    static HashMap<String, Integer> map = new HashMap<>();				// (고릴라 이름 : gorilla List에서의 인덱스 번호) 저장
    static List<PriorityQueue<Integer>> gorilla = new ArrayList<>();	// 각 고릴라가 갖고 있는 정보
    
    static void input() throws IOException {
        Q = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            
            int cmd = Integer.parseInt(st.nextToken());
            String target = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            
            if(cmd == 1) {
                getValue(target, n);
            } else {
            	buyInfo(target, n);
            }
        }
    }
    
    static void getValue(String target, int n) {
    	if(!map.containsKey(target)) {			// 새로운 고릴라인 경우, 할당해줘야 함
            map.put(target, gorilla.size());
            gorilla.add(new PriorityQueue<>(Collections.reverseOrder()));	// 내림차순
        }
    	
    	int targetIdx = map.get(target);
        
        for(int j = 0; j < n; j++) {
            int c = Integer.parseInt(st.nextToken());
            gorilla.get(targetIdx).add(c);
        }
    }
    
    static void buyInfo(String target, int n) {
    	if(!map.containsKey(target)) return;
        
    	int targetIdx = map.get(target);
    	
    	// poll() 활용해서 한번 거래한 정보 버리기
        if(gorilla.get(targetIdx).size() < n) {
            while(!gorilla.get(targetIdx).isEmpty()) {
                sum += gorilla.get(targetIdx).poll();
            }
        } else {
            for(int i = 0; i < n; i++) {
                sum += gorilla.get(targetIdx).poll();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
    	input();
        System.out.print(sum);
    }

}
