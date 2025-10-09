import java.util.*;

class Solution {
    int N;
    int[][] dice;
    boolean[] isVisited;
    List<Integer> sumList;
    int maxWin;
    int[] answer;
    
    public int[] solution(int[][] diceRaw) {
        N = diceRaw.length;
        dice = new int[N][6];
        isVisited = new boolean[N];
        sumList = new ArrayList<>();
        maxWin = 0;
        answer = new int[N/2];
        
        for(int i = 0; i < N; i++) {
            dice[i] = diceRaw[i];
        }
        
        selectDice(0, 0, new int[N / 2]);
        
        return answer;
    }
    
    private void selectDice(int index, int count, int[] arrA) {
        if(count == N/2) {
            calcWinRate(arrA);            
            return;
        }
        
        if(index >= N) {
            return;
        }
        
        for(int i = index; i < N; i++) {
            arrA[count] = i;
            isVisited[i] = true;
            
            selectDice(i + 1, count + 1, arrA);
            
            isVisited[i] = false;
        }
    }
    
    private void calcWinRate(int[] arrA) {
        int[] arrB = new int[N/2];
        int index = 0;
        
        for(int i = 0; i < N && index < N/2; i++) {
            if(!isVisited[i]) {
                arrB[index++] = i;
            }
        }
        
        sumList.clear();
        getSum(arrA, 0, 0);
        Collections.sort(sumList);
        int[] sumA = sumList.stream().mapToInt(i -> i).toArray();
        
        sumList.clear();
        getSum(arrB, 0, 0);
        Collections.sort(sumList);
        int[] sumB = sumList.stream().mapToInt(i -> i).toArray();
        
        int before = 0;
        int beforeWin = 0;
        int win = 0;
        
        for(int i = 0; i < sumA.length; i++) {
            if(sumA[i] == before) {
                win += beforeWin;
                continue;
            }
            
            int count = getUpperBound(sumB, sumA[i] - 1) + 1;
            win += count;
            
            before = sumA[i];
            beforeWin = count;
        }
        
        if(win > maxWin) {
            maxWin = win;
            
            for(int i = 0; i < N/2; i++) {
                answer[i] = arrA[i] + 1;
            }
        }
    }
    
    private void getSum(int[] arr, int index, int sum) {
        if(index >= arr.length) {
            sumList.add(sum);
            return;
        }
        
        // 주사위 눈 고르기
        for(int i = 0; i < 6; i++) {
            getSum(arr, index + 1, sum + dice[arr[index]][i]);
        }
    }
    
    private int getUpperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
}




























