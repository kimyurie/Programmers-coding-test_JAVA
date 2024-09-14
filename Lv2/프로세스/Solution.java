package Lv2.프로세스;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 우선순위 큐 선언(내림차순 버전)
        // 높은 숫자가 우선되게 하려면 () 안에 Collections.reverseOrder() 작성
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        // 우선순위 큐에 우선순위 요소 추가
        for (int i : priorities) {
            queue.offer(i); // 값 추가
        }

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 기존 우선순위 배열 순회
            for (int i = 0; i < priorities.length; i++) {
                // 현재 작업의 위치 찾기
                // .peek() // 첫 번째 값 출력(제거 X)
                if (queue.peek() == priorities[i]){
                    // .poll() // 첫 번째 값 반환, 비어있으면 null 반환
                    queue.poll();
                    answer++;

                    // 현재 작업이 location과 같으면 answer 반환
                    if(location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;

    }
}