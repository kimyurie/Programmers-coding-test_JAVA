package Lv2.기능개발;

import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int days; // 남은 작업일수
        int count; // 배포할 기능 개수

        // 첫번째 작업의 남은 일수 계산
        int prevDays = (int)Math.ceil((100.0 - progresses[0]) / speeds[0]);
        count = 1; // 첫번째 작업은 무조건 포함되므로

        for(int i = 1; i < progresses.length; i++) {
            // 현재 작업의 남은 일수 계산
            days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if(prevDays >= days){
                count++;
            }else{
                answer.add(count);
                count = 1;
                prevDays = days;
            }
        }

        answer.add(count);

        // 리스트를 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
