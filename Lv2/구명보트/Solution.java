// https://school.programmers.co.kr/learn/courses/30/lessons/42885
package Lv2.구명보트;

import java.util.*;

// 정렬 후
// 가장 몸무게가 많이 나가는 사람과 가장 몸무게가 적게 나가는 사람들끼리 보트에 태워 보내기
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // [50, 50, 70, 80]
        // [50, 70, 80]
        Arrays.sort(people);

        int index = 0; // 가장 가벼운 사람의 인덱스
        // 무거운 사람 -> 가벼운 사람 순으로 순회
        for(int i = people.length - 1; i >= index; i--) {
            // 가장 가벼운 사람 + 가장 무거운 사람이 limit 보다 작거나 같으면 두사람 묶어서 보트 한개에 태우기
            if(people[index] + people[i] <= limit) {
                answer++;
                index++;
            }else{
                answer++;
            }
        }

        return answer;
    }
}
