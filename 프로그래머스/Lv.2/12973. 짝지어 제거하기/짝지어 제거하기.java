import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] text = s.toCharArray();
        
        for(char c : text){
            if(stack.isEmpty()){
                stack.add(c);
            } else {
                if(stack.peek() == c){
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        
        int answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }
}