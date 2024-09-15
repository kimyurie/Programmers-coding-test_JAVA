// https://school.programmers.co.kr/learn/courses/30/lessons/42576
package Lv1.완주하지못한선수;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = ""; // 완주하지 못한 선수

        // 1. 참가자 이름과 등장 횟수 기록
        HashMap<String, Integer> hm = new HashMap<>();

        // 2. 각 참가자 이름 저장
        // 이름이 이미 존재하면 그 등장 횟수 1 증가시킴
        for (String player : participant) {
            // getOrDefault는 해당 키가 존재하면 그 값을 반환하고, 없으면 기본값 0을 반환
            hm.put(player, hm.getOrDefault(player, 0) + 1);
            // {"leo": 1, "kiki": 1, "eden": 1}
        }

        // 3. 완주한 선수 이름 순회하며 그 등장 횟수 1 감소시킴
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
            // {"leo": 1, "kiki": 0, "eden": 0}
        }

        // 4. 완주하지 못한 선수 찾기
        for (String key : hm.keySet()) {
            if(hm.get(key) != 0) {
                answer = key;
                // HashMap에서 값이 0이 아닌 선수는 "leo".
            }
        }

        return answer;

    }
}
