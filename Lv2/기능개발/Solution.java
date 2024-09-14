package Lv2.기능개발;

import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        // 첫 번째 작업의 남은 일수 계산
        int prevDays = (100 - progresses[0]) / speeds[0];
        if ((100 - progresses[0]) % speeds[0] != 0) {
            prevDays++;  // 남은 작업이 정확히 나눠지지 않으면 하루 더 필요
        }

        int count = 1;  // 첫 번째 작업은 무조건 포함되므로 count = 1로 시작

        for (int i = 1; i < progresses.length; i++) {
            // 현재 작업의 남은 일수 계산
            int days = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days++;  // 남은 작업이 정확히 나눠지지 않으면 하루 더 필요
            }

            if (prevDays >= days) {
                // 앞의 기능이 끝나기 전까지 현재 기능이 완료되면 함께 배포
                count++;
            } else {
                // 새로운 배포가 필요할 경우
                answer.add(count);  // 지금까지 모은 기능들을 배포
                count = 1;  // 현재 기능을 새롭게 배포할 첫 기능으로 초기화
                prevDays = days;  // 새로운 기준 날짜로 설정
            }
        }

        // 마지막으로 남은 배포 추가
        answer.add(count);

        // 리스트를 배열로 변환하여 반환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
