// https://school.programmers.co.kr/learn/courses/30/lessons/42862
package Lv1.체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 1.학생들 번호 순차적으로 배치
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 2.도난당하지 않은 학생 수 계산
        answer += n - lost.length;

        // 3.여벌이 있지만 도난당한 학생 처리(자기자신이 입어야함)
        //    ex) lost -> [2]  reserve -> [2]
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++; // 도난당했지만 자기 여벌을 사용해 수업 참여 가능
                    // -1 사용은 배열 삭제와 동일한 효과
                    lost[i] = -1; // 해당 학생은 더 이상 체육복을 빌릴 필요가 없음
                    reserve[j] = -1; // 해당 학생은 더 이상 다른 사람에게 빌려줄 수 없음
                    break;
                }
            }
        }

        // 4.다른 학생에게 체육복 빌려줌
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
                    answer++; // 체육복을 빌려받은 학생 수 증가
                    reserve[j] = -1; // 체육복을 빌려준 학생은 더 이상 빌려줄 수 없음
                    lost[i] = -1;
                    break;
                }
            }
        }

        return answer;

    }
}
