package Lv2.주식가격;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 결과를 저장할 배열
        int[] answer = new int[prices.length];

        // 스택에 주식 가격의 인덱스 저장
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // 만약 감소하는 값이 등장한다면 주식이 감소한 시점이므로
            // stack에서 해당 인덱스를 제거하고
            // i(현재 주식의 감소 시점) - stack.peek(주식이 처음 들어간 시점) 값을 ans[stack.peek]값에 넣어준다
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                // prices[3] < prices[2]
                // 2 < 3 => true
                stack.pop(); // 답을 구했기 때문에 stack에서 제거
//                answer[2] = 3 - 2 = 1
//                stack.pop(); // 2
//                stack.push(3);
            }
            stack.push(i);
        }

        // stack에 끝까지 남아 있는 경우는 끝까지 주식 가격이 떨어지지 않는 경우
        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
//            answer[4] = 5 - 4 - 1 = 0;
//            answer[3] = 5 - 3 - 1 = 1;
//            answer[1] = 5 - 1 - 1 = 3;
//            answer[0] = 5 - 0 - 1 = 4;
            stack.pop();
        }
        return answer;
    }
}
