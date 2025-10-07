import java.util.*;

/*
생성한 정점 : indegree = 0, outdegree >= 2
8자 정점 하나 : indegree = 2, outdegree = 2 (도넛 두 개를 합칠때 기준이 되는 정점)
막대 마지막 정점 : indegree = 1 or 2(생성한 정점에서의 간선), outdegree = 0;
도넛 모든 정점 : indegree = 1, outdegree = 1 -> 순회돌거나, 생성한 정점의 outdegree - 나머지 그래프 개수
*/

/*
(다른 풀이)
생성한 정점은 막대그래프의 시작점처럼 indegree = 0이지만, 그 중에서 outdegree가 가장 많다.
처음에 indegree = 0인 정점중에 시작점을 찾아서 방문 처리를 해두고, 막대 그래프부터 순회한다.
도넛이랑 8자그래프는 아무 정점이나 잡아도 되니까 1번 정점부터 차례로 확인한다. (BFS)
-> 그래프는 간선과 정점의 개수로 판별 가능하다.
*/

class Solution {
    public int[] solution(int[][] edges) {
        // 정점 번호가 순차적으로 주어진다는 보장이 없다.
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        int[] answer = new int[4];
        
        for(int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }
        
        for(int node : out.keySet()) {
            if(out.get(node) >= 2) {
                if(in.containsKey(node)) {
                    answer[3]++;
                } else {
                    answer[0] = node;
                }
            }
        }
        
        for(int node : in.keySet()) {
            if(!out.containsKey(node)) {
                answer[2]++;
            }
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}





























