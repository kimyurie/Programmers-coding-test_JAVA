// https://school.programmers.co.kr/learn/courses/30/lessons/42747
package Lv2.HIndex;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        // 배열 오름차순 정렬
        Arrays.sort(citations);
        // [0, 1, 3, 5, 6]

// citations[i]에서 i값을 증가시키고 논문의 수를 감소시키면서 비교 했을 때
// 인용 횟수가 논문의 수 이상이 되었을 때의 논문의 수가 H-Index가 된다
        for(int i = 0; i < citations.length; i++) {
            // 인용된 논문 수
            int h = citations.length - i;

            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
