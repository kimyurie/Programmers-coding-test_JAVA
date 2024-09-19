// https://school.programmers.co.kr/learn/courses/30/lessons/42626
package Lv2.더맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 우선순위 큐 : 기본은 낮은 숫자가 우선순위를 갖는다
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            que.add(scoville[i]);
        }

        // .peek() // 첫 번째 값 출력 (제거 X)
        while (que.peek() < K) {
            if (que.size() == 1) return -1;

            // .poll() // 첫 번째 값 반환
            que.add(que.poll() + que.poll() * 2);

            answer++;
        }
        return answer;
    }
}
