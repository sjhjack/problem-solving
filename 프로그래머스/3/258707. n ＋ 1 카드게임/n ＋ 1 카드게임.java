import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int N = cards.length;
        Set<Integer> inHand = new HashSet<>();
        Set<Integer> canDraw = new HashSet<>();
        int index = 0;
        int target = N + 1;
        int round = 1;
        
        for(int i = 0; i < N/3; i++) {
            inHand.add(cards[i]);
            index++;
        }
        
        // 카드를 뽑을 수 있는 동안 반복
        while(index < N) {
            boolean flag = false;
            
            canDraw.add(cards[index++]);
            canDraw.add(cards[index++]);
            
            // 손에 있는 카드로 만들기
            for(int hand : inHand) {
                if(inHand.contains(target - hand)) {
                    inHand.remove(hand);
                    inHand.remove(target - hand);
                    flag = true;
                    round++;
                    break;
                }
            }
            
            // 코인 1개 사용
            if(!flag && coin >= 1) {
                for(int hand : inHand) {
                    if(canDraw.contains(target - hand)) {
                        inHand.remove(hand);
                        canDraw.remove(target - hand);
                        coin--;
                        flag = true;
                        round++;
                        break;
                    }
                }
            }
            
            // 코인 2개 사용
            if(!flag && coin >= 2) {
                for(int draw : canDraw) {
                    if(canDraw.contains(target - draw)) {
                        canDraw.remove(draw);
                        canDraw.remove(target - draw);
                        coin -= 2;
                        flag = true;
                        round++;
                        break;
                    }
                }
            }
            
            // target을 만들지 못함
            if(!flag) {
                break;
            }
        }
        
        return round;
    }
    
    private boolean canMakeTarget(boolean[] isHave, int target) {
        for(int i = 1; i < isHave.length - 1; i++) {
            for(int j = i + 1; j < isHave.length; j++) {
                if(isHave[i] && isHave[j] && i + j == target) {
                    isHave[i] = false;
                    isHave[j] = false;
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean canMakeTargetFromHandAndDraw(boolean[] inHand, boolean[] canDraw, int target) {
        for(int i = 1; i < inHand.length; i++) {
            if(inHand[i] && canDraw[target - i]) {
                inHand[i] = false;
                canDraw[target - i] = false;
                return true;
            }
        }
        
        return false;
    }
}



























