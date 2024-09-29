package Lv1.같은숫자는싫어;
// review : 1

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 스택에 arr 속 값 넣기
        for(int i : arr) {
            // 스택이 비어있거나, 스택 최상단 값이 현재 i와 같지 않으면
            if(stack.empty() || !stack.peek().equals(i)) {
                // 스택에 집어넣기
                stack.push(i);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}