import java.io.*;
import java.util.*;

class Solution {
    Map<Integer, Integer> map;      // (그룹 번호 , 성유 덩어리 크기)
    List<Integer>[] groups;         // groups[컬럼 번호] : 컬럼 번호에 시추관 넣었을 때 마주하는 그룹들 번호
    
    int[] dr = {-1,1,0,0};          // 상하좌우
    int[] dc = {0,0,-1,1};
    int[][] myLand;                 // 입력받은 land배열 복제
    
    int R;
    int C;
    
    public class Pos {
        int row;
        int col;
        
        public Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int solution(int[][] land){
        int answer =  0;
    
        init(land);
        findGroups();
        answer = findMax();
        
        return answer;
    }
    
    public void init(int[][] land){
        R = land.length;
        C = land[0].length;
        myLand = new int[R][C];
        
        for(int i = 0; i < R; i++){
            myLand[i] = Arrays.copyOf(land[i], C);
        }
        
        map = new HashMap<>();
        groups = new ArrayList[C];
        
        for(int i = 0; i < C; i++) groups[i] = new ArrayList<>();
    }
    
    public void findGroups(){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(myLand[i][j] == 1){
                    fillGroup(i, j);
                }
            }
        }
    }
    
    public void fillGroup(int row, int col){
        Queue<Pos> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[C];

        int groupNumber = map.size() + 1;
        int cnt = 1;

        q.add(new Pos(row, col));
        myLand[row][col] = 0;

        groups[col].add(groupNumber);
        isVisited[col] = true;

        while(!q.isEmpty()){
            Pos cur = q.poll();

            for(int d = 0; d < 4; d++){
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || myLand[nr][nc] == 0) continue;

                q.add(new Pos(nr, nc));
                myLand[nr][nc] = 0;
                cnt++;

                if(!isVisited[nc]){
                    groups[nc].add(groupNumber);
                    isVisited[nc] = true;
                }
            }
        }

        map.put(groupNumber, cnt);
    }
    
    public int findMax(){
        int max = 0;
        
        for(int i = 0; i < C; i++){
            int sum = 0;
            for(int group : groups[i]){
                sum += map.get(group);
            }
            max = Math.max(max, sum);
        }
        
        return max;
    }
}
